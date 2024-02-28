package bzu.computerscience.encryption_alorithms;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

public class HelloApplication extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        TextArea inputTextField, outputTextField;
        TextField keyTextField;
        BorderPane borderPane = new BorderPane();
        borderPane.setStyle("-fx-background-color: #F0F4EF");
        borderPane.setPadding(new Insets(20, 20, 20, 20));

        VBox algorithmBox = new VBox(20);
        algorithmBox.setPadding(new Insets(20, 20, 20, 20));
        algorithmBox.setAlignment(Pos.CENTER);
        borderPane.setCenter(algorithmBox);

        Label label = new Label("      Confusion and Diffusion Algorithms     ");
        label.setFont(Font.font("Georgia", FontWeight.BOLD, 28));
        label.setStyle("-fx-text-fill: #4d3423");
        label.setAlignment(Pos.CENTER);

        // h-box for the title
        HBox titleBox = new HBox(20);
        titleBox.setPadding(new Insets(20, 20, 20, 20));
        titleBox.setAlignment(Pos.CENTER);
        titleBox.getChildren().addAll(label);
        borderPane.setTop(titleBox);

        // three text boxes for input, output and key
        inputTextField = new TextArea();
        inputTextField.setPromptText("Enter the plain text");
        inputTextField.setPrefSize(400, 100);
        inputTextField.setStyle("-fx-background-color: rgba(218,218,218,0.45); -fx-text-fill: #4d3423; -fx-border-style: solid; -fx-border-color: #4d3423; -fx-border-radius: 5px; -fx-font: 15px \"Georgia\" ");

        keyTextField = new TextField();
        keyTextField.setPromptText("Enter the key");
        keyTextField.setPrefSize(400, 50);
        keyTextField.setStyle("-fx-background-color: rgba(218,218,218,0.45); -fx-text-fill: #4d3423; -fx-border-style: solid; -fx-border-color: #4d3423; -fx-border-radius: 5px; -fx-font: 15px \"Georgia\" ");

        outputTextField = new TextArea();
        outputTextField.setPromptText("Enter the cipher text");
        outputTextField.setPrefSize(400, 100);
        outputTextField.setStyle("-fx-background-color: rgba(218,218,218,0.45); -fx-text-fill: #4d3423; -fx-border-style: solid; -fx-border-color: #4d3423; -fx-border-radius: 5px; -fx-font: 15px \"Georgia\" ");
        outputTextField.setEditable(false);


        // vbox for input, output and key
        VBox inputOutputKeyBox = new VBox(20);
        inputOutputKeyBox.setPadding(new Insets(20, 20, 20, 20));
        inputOutputKeyBox.setAlignment(Pos.CENTER);
        inputOutputKeyBox.getChildren().addAll(inputTextField, keyTextField, outputTextField);
        borderPane.setCenter(inputOutputKeyBox);

        // Radio button for selecting caesarRadioButton
        RadioButton caesarRadioButton = new RadioButton("Caesar Cipher");
        caesarRadioButton.setStyle("-fx-text-fill: #4d3423; -fx-font-family: Georgia; -fx-font-size: 15px; -fx-font-weight: bold; -fx-border-style: solid; -fx-border-color: #4d3423; -fx-border-radius: 5px; -fx-background-color: rgba(218,218,218,0.45); -fx-padding: 10px; -fx-border-width: 2px;");
        caesarRadioButton.setPrefSize(300, 50);

        // Radio button for selecting columnarRadioButton
        RadioButton columnarRadioButton = new RadioButton("Columnar Cipher");
        columnarRadioButton.setPrefSize(300, 50);
        columnarRadioButton.setStyle("-fx-text-fill: #4d3423; -fx-font-family: Georgia; -fx-font-size: 15px; -fx-font-weight: bold; -fx-border-style: solid; -fx-border-color: #4d3423; -fx-border-radius: 5px; -fx-background-color: rgba(218,218,218,0.45); -fx-padding: 10px; -fx-border-width: 2px;");

        // Radio button for selecting columnarWithCaesarRadioButton
        RadioButton columnarWithCaesarRadioButton = new RadioButton("Columnar with Caesar Cipher");
        columnarWithCaesarRadioButton.setPrefSize(300, 50);
        columnarWithCaesarRadioButton.setStyle("-fx-text-fill: #4d3423; -fx-font-family: Georgia; -fx-font-size: 15px; -fx-font-weight: bold; -fx-border-style: solid; -fx-border-color: #4d3423; -fx-border-radius: 5px; -fx-background-color: rgba(218,218,218,0.45); -fx-padding: 10px; -fx-border-width: 2px;");

        // radio button for rail fence
        RadioButton railFenceRadioButton = new RadioButton("Rail Fence Cipher");
        railFenceRadioButton.setPrefSize(300, 50);
        railFenceRadioButton.setStyle("-fx-text-fill: #4d3423; -fx-font-family: Georgia; -fx-font-size: 15px; -fx-font-weight: bold; -fx-border-style: solid; -fx-border-color: #4d3423; -fx-border-radius: 5px; -fx-background-color: rgba(218,218,218,0.45); -fx-padding: 10px; -fx-border-width: 2px;");

        // rail-fence with caesar with columnar
        RadioButton railFenceWithCaesarWithColumnarRadioButton = new RadioButton("RailColumnarCaesar Cipher");
        railFenceWithCaesarWithColumnarRadioButton.setPrefSize(300, 50);
        railFenceWithCaesarWithColumnarRadioButton.setStyle("-fx-text-fill: #4d3423; -fx-font-family: Georgia; -fx-font-size: 15px; -fx-font-weight: bold; -fx-border-style: solid; -fx-border-color: #4d3423; -fx-border-radius: 5px; -fx-background-color: rgba(218,218,218,0.45); -fx-padding: 10px; -fx-border-width: 2px;");


        // toggle group for radio buttons
        ToggleGroup toggleGroup = new ToggleGroup();
        caesarRadioButton.setToggleGroup(toggleGroup);
        columnarRadioButton.setToggleGroup(toggleGroup);
        columnarWithCaesarRadioButton.setToggleGroup(toggleGroup);
        railFenceRadioButton.setToggleGroup(toggleGroup);
        railFenceWithCaesarWithColumnarRadioButton.setToggleGroup(toggleGroup);

        // radio group for the radio buttons
        VBox radioGroup = new VBox(20);
        radioGroup.setPadding(new Insets(20, 20, 20, 20));
        radioGroup.setAlignment(Pos.CENTER);
        radioGroup.getChildren().addAll(caesarRadioButton, columnarRadioButton, columnarWithCaesarRadioButton, railFenceRadioButton, railFenceWithCaesarWithColumnarRadioButton);
        borderPane.setLeft(radioGroup);

        // button for encryption
        Button encryptButton = new Button("Encrypt");
        encryptButton.setPrefSize(200, 50);
        encryptButton.setStyle("-fx-background-color: #4d3423; -fx-text-fill: #F0F4EF; -fx-border-style: solid; -fx-border-color: #4d3423; -fx-border-radius: 5px; -fx-font-family: Georgia; -fx-font-size: 15px; -fx-font-weight: bold; -fx-padding: 10px; -fx-border-width: 2px;");
        encryptButton.setOnAction(e -> {
            if (caesarRadioButton.isSelected()) {
                // check if the key is a number
                if (!keyTextField.getText().matches("[0-9]+")) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Invalid key");
                    alert.setContentText("Please enter a valid key");
                    alert.showAndWait();
                    return;
                }
                // check if the key is in the range of 1 to 25
                if (Integer.parseInt(keyTextField.getText()) < 1 || Integer.parseInt(keyTextField.getText()) > 25) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Invalid key");
                    alert.setContentText("Please enter a valid key");
                    alert.showAndWait();
                    return;
                }
                outputTextField.setText(CeaserCipherVowel.encrypt(inputTextField.getText(), Integer.parseInt(keyTextField.getText())));
            } else if (columnarRadioButton.isSelected()) {
                // check if the key is a number
                if (!keyTextField.getText().matches("[0-9]+")) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Invalid key");
                    alert.setContentText("Please enter a valid key");
                    alert.showAndWait();
                    return;
                }
                outputTextField.setText(ColumnarCipher.encrypt(inputTextField.getText(), String.valueOf(Integer.parseInt(keyTextField.getText()))));
            } else if (columnarWithCaesarRadioButton.isSelected()) {
                // check if the key is a number
                if (!keyTextField.getText().matches("[0-9]+")) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Invalid key");
                    alert.setContentText("Please enter a valid key");
                    alert.showAndWait();
                    return;
                }
                // check if the key is in the range of 1 to 25
                if (Integer.parseInt(keyTextField.getText()) < 1 || Integer.parseInt(keyTextField.getText()) > 25) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Invalid key");
                    alert.setContentText("Please enter a valid key");
                    alert.showAndWait();
                    return;
                }
                outputTextField.setText(ColumnarWithCeaserCipher.encrypt(inputTextField.getText(), Integer.parseInt(keyTextField.getText())));
            } else if (railFenceRadioButton.isSelected()) {
                // check if the key is a number
                if (!keyTextField.getText().matches("[0-9]+")) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Invalid key");
                    alert.setContentText("Please enter a valid key");
                    alert.showAndWait();
                    return;
                }
                outputTextField.setText(RailFenceCipher.encrypt(inputTextField.getText(), Integer.parseInt(keyTextField.getText())));
            } else if (railFenceWithCaesarWithColumnarRadioButton.isSelected()){
                // check if the key is a number
                if (!keyTextField.getText().matches("[0-9]+")) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Invalid key");
                    alert.setContentText("Please enter a valid key");
                    alert.showAndWait();
                    return;
                }
                // check if the key is in the range of 1 to 25
                if (Integer.parseInt(keyTextField.getText()) < 1 || Integer.parseInt(keyTextField.getText()) > 25) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Invalid key");
                    alert.setContentText("Please enter a valid key");
                    alert.showAndWait();
                    return;
                }
                outputTextField.setText(RailColumnCeaser.encrypt(inputTextField.getText(), Integer.parseInt(keyTextField.getText())));
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("No algorithm selected");
                alert.setContentText("Please select an algorithm to encrypt");
                alert.showAndWait();
            }
        });

        // button for decryption
        Button decryptButton = new Button("Decrypt");
        decryptButton.setPrefSize(200, 50);
        decryptButton.setStyle("-fx-background-color: #4d3423; -fx-text-fill: #F0F4EF; -fx-border-style: solid; -fx-border-color: #4d3423; -fx-border-radius: 5px; -fx-font-family: Georgia; -fx-font-size: 15px; -fx-font-weight: bold;");
        decryptButton.setOnAction(e -> {
            if (caesarRadioButton.isSelected()) {
                // check if the key is a number
                if (!keyTextField.getText().matches("[0-9]+")) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Invalid key");
                    alert.setContentText("Please enter a valid key");
                    alert.showAndWait();
                    return;
                }
                // check if the key is in the range of 1 to 25
                if (Integer.parseInt(keyTextField.getText()) < 1 || Integer.parseInt(keyTextField.getText()) > 25) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Invalid key");
                    alert.setContentText("Please enter a valid key");
                    alert.showAndWait();
                    return;
                }
                outputTextField.setText(CeaserCipherVowel.decrypt(inputTextField.getText(), Integer.parseInt(keyTextField.getText())));
            } else if (columnarRadioButton.isSelected()) {
                // check if the key is a number
                if (!keyTextField.getText().matches("[0-9]+")) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Invalid key");
                    alert.setContentText("Please enter a valid key");
                    alert.showAndWait();
                    return;
                }
                outputTextField.setText(ColumnarCipher.decryptFX(inputTextField.getText(), String.valueOf(Integer.parseInt(keyTextField.getText()))));
            } else if (columnarWithCaesarRadioButton.isSelected()) {
                // check if the key is a number
                if (!keyTextField.getText().matches("[0-9]+")) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Invalid key");
                    alert.setContentText("Please enter a valid key");
                    alert.showAndWait();
                    return;
                }
                // check if the key is in the range of 1 to 25
                if (Integer.parseInt(keyTextField.getText()) < 1 || Integer.parseInt(keyTextField.getText()) > 25) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Invalid key");
                    alert.setContentText("Please enter a valid key");
                    alert.showAndWait();
                    return;
                }
                outputTextField.setText(ColumnarWithCeaserCipher.decrypt(inputTextField.getText(), Integer.parseInt(keyTextField.getText())));
            } else if (railFenceRadioButton.isSelected()) {
                outputTextField.setText(RailFenceCipher.decrypt(inputTextField.getText(), Integer.parseInt(keyTextField.getText())));

            } else if (railFenceWithCaesarWithColumnarRadioButton.isSelected()){
                outputTextField.setText(RailColumnCeaser.decrypt(inputTextField.getText(), Integer.parseInt(keyTextField.getText())));
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("No algorithm selected");
                alert.setContentText("Please select an algorithm to decrypt");
                alert.showAndWait();
            }
        });

        // button file chooser encryption
        Button fileChooserEncryptButton = new Button("Encrypt File");
        fileChooserEncryptButton.setPrefSize(200, 50);
        fileChooserEncryptButton.setStyle("-fx-background-color: #858d67; -fx-text-fill: #F0F4EF; -fx-border-style: solid; -fx-border-color: #727958; -fx-border-radius: 5px; -fx-font-family: Georgia; -fx-font-size: 15px; -fx-font-weight: bold;");
        fileChooserEncryptButton.setOnAction(e -> {
            Stage stage1 = new Stage();
            if (caesarRadioButton.isSelected()) {
                // check if the key is a number
                if (!keyTextField.getText().matches("[0-9]+")) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Invalid key");
                    alert.setContentText("Please enter a valid key");
                    alert.showAndWait();
                    return;
                }
                // check if the key is in the range of 1 to 25
                if (Integer.parseInt(keyTextField.getText()) < 1 || Integer.parseInt(keyTextField.getText()) > 25) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Invalid key");
                    alert.setContentText("Please enter a valid key");
                    alert.showAndWait();
                    return;
                }

                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Choose a file to encrypt");
                File file = fileChooser.showOpenDialog(stage1);
                if (file != null) {
                    try {
                        String encryptedText = CeaserCipherVowel.encrypt(new String(Files.readAllBytes(file.toPath())), Integer.parseInt(keyTextField.getText()));
                        FileChooser fileChooser1 = new FileChooser();
                        fileChooser1.setTitle("Choose a file to save the encrypted text");
                        File file1 = fileChooser1.showSaveDialog(stage1);
                        if (file1 != null) {
                            PrintWriter printWriter = new PrintWriter(file1);
                            printWriter.print(encryptedText);
                            printWriter.close();

                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Success");
                            alert.setHeaderText("File encrypted successfully");
                            alert.setContentText("The encrypted text has been saved in the file");
                            alert.showAndWait();
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            } else if (columnarRadioButton.isSelected()) {
                // check if the key is a number
                if (!keyTextField.getText().matches("[0-9]+")) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Invalid key");
                    alert.setContentText("Please enter a valid key");
                    alert.showAndWait();
                    return;
                }

                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Choose a file to encrypt");
                File file = fileChooser.showOpenDialog(stage1);
                if (file != null) {
                    try {
                        String encryptedText = ColumnarCipher.encrypt(new String(Files.readAllBytes(file.toPath())), String.valueOf(Integer.parseInt(keyTextField.getText())));
                        FileChooser fileChooser1 = new FileChooser();
                        fileChooser1.setTitle("Choose a file to save the encrypted text");
                        File file1 = fileChooser1.showSaveDialog(stage1);
                        if (file1 != null) {
                            PrintWriter printWriter = new PrintWriter(file1);
                            printWriter.print(encryptedText);
                            printWriter.close();

                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Success");
                            alert.setHeaderText("File encrypted successfully");
                            alert.setContentText("The encrypted text has been saved in the file");
                            alert.showAndWait();
                        }

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            } else if (columnarWithCaesarRadioButton.isSelected()) {
                // check if the key is a number
                if (!keyTextField.getText().matches("[0-9]+")) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Invalid key");
                    alert.setContentText("Please enter a valid key");
                    alert.showAndWait();
                    return;
                }
                // check if the key is in the range of 1 to 25
                if (Integer.parseInt(keyTextField.getText()) < 1 || Integer.parseInt(keyTextField.getText()) > 25) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Invalid key");
                    alert.setContentText("Please enter a valid key");
                    alert.showAndWait();
                    return;
                }

                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Choose a file to encrypt");
                File file = fileChooser.showOpenDialog(stage1);
                if (file != null) {
                    try {
                        String encryptedText = ColumnarWithCeaserCipher.encrypt(new String(Files.readAllBytes(file.toPath())), Integer.parseInt(keyTextField.getText()));
                        FileChooser fileChooser1 = new FileChooser();
                        fileChooser1.setTitle("Choose a file to save the encrypted text");
                        File file1 = fileChooser1.showSaveDialog(stage1);
                        if (file1 != null) {
                            PrintWriter printWriter = new PrintWriter(file1);
                            printWriter.print(encryptedText);
                            printWriter.close();

                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Success");
                            alert.setHeaderText("File encrypted successfully");
                            alert.setContentText("The encrypted text has been saved in the file");
                            alert.showAndWait();
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            } else if (railFenceRadioButton.isSelected()) {
                // check if the key is a number
                if (!keyTextField.getText().matches("[0-9]+")) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Invalid key");
                    alert.setContentText("Please enter a valid key");
                    alert.showAndWait();
                    return;
                }
                // check if the key is in the range of 1 to 25
                if (Integer.parseInt(keyTextField.getText()) < 1 || Integer.parseInt(keyTextField.getText()) > 25) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Invalid key");
                    alert.setContentText("Please enter a valid key");
                    alert.showAndWait();
                    return;
                }

                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Choose a file to encrypt");
                File file = fileChooser.showOpenDialog(stage1);
                if (file != null) {
                    try {
                        String encryptedText = RailFenceCipher.encrypt(new String(Files.readAllBytes(file.toPath())), Integer.parseInt(keyTextField.getText()));
                        FileChooser fileChooser1 = new FileChooser();
                        fileChooser1.setTitle("Choose a file to save the encrypted text");
                        File file1 = fileChooser1.showSaveDialog(stage1);
                        if (file1 != null) {
                            PrintWriter printWriter = new PrintWriter(file1);
                            printWriter.print(encryptedText);
                            printWriter.close();

                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Success");
                            alert.setHeaderText("File encrypted successfully");
                            alert.setContentText("The encrypted text has been saved in the file");
                            alert.showAndWait();
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            } else if (railFenceWithCaesarWithColumnarRadioButton.isSelected()){
                // check if the key is a number
                if (!keyTextField.getText().matches("[0-9]+")) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Invalid key");
                    alert.setContentText("Please enter a valid key");
                    alert.showAndWait();
                    return;
                }
                // check if the key is in the range of 1 to 25
                if (Integer.parseInt(keyTextField.getText()) < 1 || Integer.parseInt(keyTextField.getText()) > 25) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Invalid key");
                    alert.setContentText("Please enter a valid key");
                    alert.showAndWait();
                    return;
                }

                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Choose a file to encrypt");
                File file = fileChooser.showOpenDialog(stage1);
                if (file != null) {
                    try {
                        String encryptedText = RailColumnCeaser.encrypt(new String(Files.readAllBytes(file.toPath())), Integer.parseInt(keyTextField.getText()));
                        FileChooser fileChooser1 = new FileChooser();
                        fileChooser1.setTitle("Choose a file to save the encrypted text");
                        File file1 = fileChooser1.showSaveDialog(stage1);
                        if (file1 != null) {
                            PrintWriter printWriter = new PrintWriter(file1);
                            printWriter.print(encryptedText);
                            printWriter.close();

                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Success");
                            alert.setHeaderText("File encrypted successfully");
                            alert.setContentText("The encrypted text has been saved in the file");
                            alert.showAndWait();
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("No algorithm selected");
                alert.setContentText("Please select an algorithm to encrypt");
                alert.showAndWait();
            }
        });

        // button file chooser decryption
        Button fileChooserDecryptButton = new Button("Decrypt File");
        fileChooserDecryptButton.setPrefSize(200, 50);
        fileChooserDecryptButton.setStyle("-fx-background-color: #858d67; -fx-text-fill: #F0F4EF; -fx-border-style: solid; -fx-border-color: #727958; -fx-border-radius: 5px; -fx-font-family: Georgia; -fx-font-size: 15px; -fx-font-weight: bold;");
        fileChooserDecryptButton.setOnAction(e -> {
            Stage stage1 = new Stage();
            if (caesarRadioButton.isSelected()) {
                // check if the key is a number
                if (!keyTextField.getText().matches("[0-9]+")) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Invalid key");
                    alert.setContentText("Please enter a valid key");
                    alert.showAndWait();
                    return;
                }
                // check if the key is in the range of 1 to 25
                if (Integer.parseInt(keyTextField.getText()) < 1 || Integer.parseInt(keyTextField.getText()) > 25) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Invalid key");
                    alert.setContentText("Please enter a valid key");
                    alert.showAndWait();
                    return;
                }

                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Choose a file to decrypt");
                File file = fileChooser.showOpenDialog(stage1);
                if (file != null) {
                    try {
                        String decryptedText = CeaserCipherVowel.decrypt(new String(Files.readAllBytes(file.toPath())), Integer.parseInt(keyTextField.getText()));
                        FileChooser fileChooser1 = new FileChooser();
                        fileChooser1.setTitle("Choose a file to save the decrypted text");
                        File file1 = fileChooser1.showSaveDialog(stage1);
                        if (file1 != null) {
                            PrintWriter printWriter = new PrintWriter(file1);
                            printWriter.print(decryptedText);
                            printWriter.close();

                            // show a message that the file has been decrypted successfully
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Success");
                            alert.setHeaderText("File decrypted successfully");
                            alert.setContentText("The file has been decrypted successfully");
                            alert.showAndWait();
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            } else if (columnarRadioButton.isSelected()) {
                // check if the key is a number
                if (!keyTextField.getText().matches("[0-9]+")) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Invalid key");
                    alert.setContentText("Please enter a valid key");
                    alert.showAndWait();
                    return;
                }

                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Choose a file to decrypt");
                File file = fileChooser.showOpenDialog(stage1);
                if (file != null) {
                    try {
                        String decryptedText = ColumnarCipher.decryptFX(new String(Files.readAllBytes(file.toPath())), String.valueOf(Integer.parseInt(keyTextField.getText())));
                        // save the decrypted text in a file
                        FileChooser fileChooser1 = new FileChooser();
                        fileChooser1.setTitle("Choose a file to save the decrypted text");
                        File file1 = fileChooser1.showSaveDialog(stage1);
                        if (file1 != null) {
                            PrintWriter printWriter = new PrintWriter(file1);
                            printWriter.print(decryptedText);
                            printWriter.close();

                            // success alert
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Success");
                            alert.setHeaderText("File decrypted successfully");
                            alert.setContentText("File decrypted successfully");
                            alert.showAndWait();
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            } else if (columnarWithCaesarRadioButton.isSelected()) {
                // check if the key is a number
                if (!keyTextField.getText().matches("[0-9]+")) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Invalid key");
                    alert.setContentText("Please enter a valid key");
                    alert.showAndWait();
                    return;
                }

                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Choose a file to decrypt");
                File file = fileChooser.showOpenDialog(stage1);
                if (file != null) {
                    try {
                        String decryptedText = ColumnarWithCeaserCipher.decrypt(new String(Files.readAllBytes(file.toPath())), Integer.parseInt(String.valueOf(Integer.parseInt(keyTextField.getText()))));                        // save the decrypted text in a file
                        FileChooser fileChooser1 = new FileChooser();
                        fileChooser1.setTitle("Choose a file to save the decrypted text");
                        File file1 = fileChooser1.showSaveDialog(stage1);
                        if (file1 != null) {
                            PrintWriter printWriter = new PrintWriter(file1);
                            printWriter.print(decryptedText);
                            printWriter.close();

                            // success alert
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Success");
                            alert.setHeaderText("File decrypted successfully");
                            alert.setContentText("File decrypted successfully");
                            alert.showAndWait();
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            } else if (railFenceWithCaesarWithColumnarRadioButton.isSelected()){
                // check if the key is a number
                if (!keyTextField.getText().matches("[0-9]+")) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Invalid key");
                    alert.setContentText("Please enter a valid key");
                    alert.showAndWait();
                    return;
                }

                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Choose a file to decrypt");
                File file = fileChooser.showOpenDialog(stage1);
                if (file != null) {
                    try {
                        String decryptedText = RailColumnCeaser.decrypt(new String(Files.readAllBytes(file.toPath())), Integer.parseInt(String.valueOf(Integer.parseInt(keyTextField.getText()))));
                        // save the decrypted text in a file
                        FileChooser fileChooser1 = new FileChooser();
                        fileChooser1.setTitle("Choose a file to save the decrypted text");
                        File file1 = fileChooser1.showSaveDialog(stage1);
                        if (file1 != null) {
                            PrintWriter printWriter = new PrintWriter(file1);
                            printWriter.print(decryptedText);
                            printWriter.close();

                            // success alert
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Success");
                            alert.setHeaderText("File decrypted successfully");
                            alert.setContentText("File decrypted successfully");
                            alert.showAndWait();
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
            else if (railFenceRadioButton.isSelected()) {
                // check if the key is a number
                if (!keyTextField.getText().matches("[0-9]+")) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Invalid key");
                    alert.setContentText("Please enter a valid key");
                    alert.showAndWait();
                    return;
                }

                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Choose a file to decrypt");
                File file = fileChooser.showOpenDialog(stage1);
                if (file != null) {
                    try {
                        String decryptedText = RailFenceCipher.decrypt((new String(Files.readAllBytes(file.toPath()))), Integer.parseInt(keyTextField.getText().trim()));
                        // save the decrypted text in a file
                        FileChooser fileChooser1 = new FileChooser();
                        fileChooser1.setTitle("Choose a file to save the decrypted text");
                        File file1 = fileChooser1.showSaveDialog(stage1);
                        if (file1 != null) {
                            PrintWriter printWriter = new PrintWriter(file1);
                            printWriter.print(decryptedText);
                            printWriter.close();

                            // success alert
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Success");
                            alert.setHeaderText("File decrypted successfully");
                            alert.setContentText("File decrypted successfully");
                            alert.showAndWait();
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        // h-box for the buttons
        HBox buttonBox = new HBox(20);
        buttonBox.setPadding(new Insets(20, 20, 20, 20));
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(encryptButton, decryptButton, fileChooserEncryptButton, fileChooserDecryptButton);
        borderPane.setBottom(buttonBox);

        // scene and stage
        Scene scene = new Scene(borderPane);
        stage = new Stage();
        stage.setScene(scene);
        stage.setMinWidth(650);
        stage.setMinHeight(500);
        stage.setResizable(true);
        stage.setTitle("Confusion and Diffusion Algorithms");
        stage.show();
    }
}