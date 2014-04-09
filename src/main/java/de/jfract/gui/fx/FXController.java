package de.jfract.gui.fx;

import de.jfract.ApplicationContext;
import de.jfract.math.*;
import de.jfract.math.color.*;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import org.controlsfx.dialog.Dialogs;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * User: kesper
 * Date: 16.01.14
 * Time: 13:50
 */
public class FXController implements Initializable, EventHandler<javafx.scene.input.MouseEvent>{

    @FXML
    private MenuBar menuBar;

    @FXML
    private ScrollPane scrollpane;

    @FXML
    private ProgressBar progressBar;

    private File lastSelectedDirectory;

    private ArrayList<ColorModel> models = new ArrayList<ColorModel>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        models.add(new DefaultModel());
        models.add(new CandyColorModel());
        models.add(new MudColorModel());
        models.add(new SimpleGreyModel());
        models.add(new AlternatingModel());

        scrollpane.setOnMouseClicked(this);

        if (lastSelectedDirectory==null) {
            lastSelectedDirectory = new File(".");
        }
    }

    public void loadAction() throws IOException, ClassNotFoundException {
        FileChooser chooser = new FileChooser();
        if (lastSelectedDirectory!=null) {
            chooser.setInitialDirectory(lastSelectedDirectory);
        }
        chooser.setTitle("Open ...");
        File file = chooser.showOpenDialog(null);

        if (file!=null) {
            System.out.println("DEBUG: choosen file: "+file.getAbsoluteFile());
            lastSelectedDirectory = file.getParentFile();
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            FractalPars pars = (FractalPars)ois.readObject();
            ApplicationContext.getInstance().setFractalParameters(pars);
            redraw();
        }
    }

    public void saveAction() throws IOException {
        FileChooser chooser = new FileChooser();
        if (lastSelectedDirectory!=null) {
            chooser.setInitialDirectory(lastSelectedDirectory);
        }
        chooser.setTitle("Save ...");
        File file = chooser.showSaveDialog(null);
        if (file!=null) {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(ApplicationContext.getInstance().getFractalParameters());
            oos.flush();
            oos.close();
            fos.flush();
            fos.close();
        }
    }

    public void exportAction() {
        System.err.println("ERROR: exportAction() not implemented yet.");
    }

    public void changeIterationAction() {
        String response = Dialogs.create()
                .title("Calculation depth of the algorithm")
                .masthead("Please enter your desired maximum iteration value.")
                .message("Enter: ")
                .showTextInput(""+ApplicationContext.getInstance().getFractalParameters().getMaxit());

        if (response!=null) {
            try {
                int it = Integer.parseInt(response);
                ApplicationContext.getInstance().getFractalParameters().setMaxit(it);
                redraw();
            } catch(NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    public void changeColorModelAction() {

        ApplicationContext ac = ApplicationContext.getInstance();

        ColorModel selected = Dialogs.create().title("Color Model")
                .masthead("Please choose your preferred color model")
                .showChoices(ac.getFractalParameters().getColorModel(), models);

        if (selected!=null) {
            ac.getFractalParameters().setColorModel(selected);
            redraw();
        }
    }

    public void exitAction() {
        System.exit(0);
    }

    public void changeParametersAction() {
        System.err.println("ERROR: changeParametersAction() not implemented yet.");
    }

    public void mandelAction() {
        setFractal(new Mandel());
    }

    public void mandelAction3() {
        setFractal(new Mandel4());
    }

    public void juliaAction() {
        setFractal(new Julia());
    }

    public void eyeOfTheBeastAction() {
        setFractal(new TheEyeOfTheBeast());
    }

    public void convergenceDivergenceAction() {
        setFractal(new ConvergenceDivergence());
    }

    public void convergenceDivergenceTwoAction() {
        setFractal(new ConvergenceDivergenceTwo());
    }

    public void circularImpressionAction() {
        setFractal(new CircularImpression());
    }

    public void doubleHeadedDudeAction() {
        setFractal(new DoubleHeadedDude());
    }

    public void tripleHeadedDudeAction() {
        setFractal(new TripleHeadedDude());
    }

    public void lotkaAction() {
        setFractal(new Lotka());
    }

    public void anotherChaosAction() {
        setFractal(new AnotherChaos());
    }

    public void ellipticFunctionAction() {
        setFractal(new EllipticFunction());
    }

    private void setFractal(Fractal fractal) {
        ApplicationContext ac = ApplicationContext.getInstance();

        FractalPars fp = ac.getFractalParameters();
        if (fp==null) {
            fp = new FractalPars();
            ac.setFractalParameters(fp);
        }

        fp.setFractal(fractal);
        fp.setMaxit(fractal.getPreferredMaxIt());
        fp.setStartPoint(fractal.getPreferredStartPoint());
        fp.setFixPoint(fractal.getPreferredFixPoint());
        fp.setD(fractal.getPreferredD());
        fp.setCenterX(fractal.getPreferredCenterPoint().real());
        fp.setCenterY(fractal.getPreferredCenterPoint().imaginary());
        ac.setFractalParameters(fp);

        redraw();
    }

    public void redraw() {

        final Bounds bounds = scrollpane.getViewportBounds();


        final BufferedImage bi = new BufferedImage((int)bounds.getWidth(), (int)bounds.getHeight(),BufferedImage.TYPE_INT_RGB);
        progressBar.setProgress(0.);
        ApplicationContext.getInstance().recalculate(bi, (int) bounds.getWidth(), (int) bounds.getHeight(), new ApplicationContext.CalculationMonitor() {
            @Override
            public void setProgress(int percent) {
                progressBar.setProgress(((double)percent)/100.);
            }

            @Override
            public void calculationFinished() {
                final WritableImage wi = SwingFXUtils.toFXImage(bi,null);

                progressBar.setProgress(1.);

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        final Canvas canvas = new Canvas(bounds.getWidth(), bounds.getHeight());
                        GraphicsContext gc = canvas.getGraphicsContext2D();
                        gc.drawImage(wi, 0, 0);
                        scrollpane.setContent(canvas);
                    }
                });
            }

            @Override
            public void setCalculationCanceled() {

            }

            @Override
            public boolean isCanceled() {
                return false;
            }
        });
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        double x = mouseEvent.getX();
        double y = mouseEvent.getY();
        MouseButton button = mouseEvent.getButton();

        int width = (int)scrollpane.getWidth();
        int heigth = (int)scrollpane.getHeight();

        boolean recalc = false;
        if (button == MouseButton.PRIMARY) {
            ApplicationContext.getInstance().getFractalParameters().zoomIn((int)x, (int)y, width, heigth);
            recalc = true;
        } else if (button == MouseButton.SECONDARY) {
            ApplicationContext.getInstance().getFractalParameters().zoomOut((int)x, (int)y,width,heigth);
            recalc = true;
        } else if (button == MouseButton.MIDDLE) {
            ApplicationContext.getInstance().getFractalParameters().pan((int)x, (int)y,width,heigth);
            recalc = true;
        }
        if (recalc) {
            redraw();
        }
    }
}
