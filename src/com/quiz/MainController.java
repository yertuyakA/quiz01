package com.quiz;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainController {

    @FXML
    TextField enterLogin, enterNickname;
    @FXML
    TextArea promptArea;
    @FXML
    PasswordField enterPassword;
    @FXML
    Button mainButton, registerButton, btnTheme, btnScore, btnSimple, btnSportTheme, btnMovieTheme, btnNext, answer1, answer2, answer3, answer4;
    @FXML
    Label labelNickname, userMaxScore, questTheme, prompt, labelTheme;


    DBService dbService;
    private static String activeLogin;
    private static String rightAnswer;
    private static boolean isRight = false;
    private static boolean isMovieTheme = false;
    private static boolean isSportTheme = false;
    private static int questionScore;
    private static int totalScore;
    private static int qIndex;

    void setActiveLogin(String activeLogin) {
        this.activeLogin = activeLogin;
    }

    String getActiveLogin() {
        return activeLogin;
    }

    void setRightAnswer() {
        this.rightAnswer = rightAnswer;
    }

    String getRightAnswer() {
        return rightAnswer;
    }

    int getQuestionScore() {
        return questionScore;
    }

    public void setQuestionScore() {
        this.questionScore = questionScore;
    }

    int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore() {
        this.totalScore = totalScore;
    }

    @FXML
    void click(ActionEvent event) {
        //запуск авторизации при нажатии кнопки Log in;
        dbService = new DBService();

        try {
            if (dbService.isRegistered(enterLogin.getText().toString(), enterPassword.getText().toString())) {
                System.out.println("TRUE!!!");
                activeLogin = enterLogin.getText().toString();
                System.out.println(activeLogin + " authorized");

                URL xmlUrl = getClass().getResource("menu.fxml");
                Parent root = FXMLLoader.load(xmlUrl);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene sc = new Scene(root);
                stage.setScene(sc);


            } else {
                System.out.println("User not found");
                prompt.setText("Пользователь не найден");
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();

        }

    }

    @FXML
    void click1() {
        registerButton.setText("Сохранить");
        enterNickname.setVisible(true);
        labelNickname.setVisible(true);
        prompt.setText("Заполните данные для регистрации");
        mainButton.setVisible(false);
        registerButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                createUser();
            }


        });

    }

    @FXML
        //Регистрация;
    void createUser() {
        dbService = new DBService();
        try {
            String writeNickname = enterNickname.getText();
            String writeLogin = enterLogin.getText();
            String writePassword = enterPassword.getText();
            if (dbService.loginExist(writeLogin)) {
                //проверка на уникальность поля login в таблице users;
                System.out.println("User exist");
                prompt.setText("Пользователь существует");
            } else {
                dbService.write(writeNickname, writePassword, writeLogin);
                prompt.setText("Вы успешно зарегистрированы!");
                registerButton.setText("Регистрация");
                labelNickname.setVisible(false);
                enterNickname.setVisible(false);
                mainButton.setVisible(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    @FXML
    void getScore() {
        dbService = new DBService();
        //вывод счета пользователя из базы поле max_score;
        int maxScore = 0;
        try {
            maxScore = dbService.getMaxScore(activeLogin);
            userMaxScore.setText("Счет: " + String.valueOf(maxScore));
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @FXML
    void exitQuiz() {
        //выход из программы;
        System.exit(1);
    }

    @FXML
    void getTheme(ActionEvent event) throws IOException {
        //выводить  окно выбора тем с вопросами;
        URL xmlUrl = getClass().getResource("theme.fxml");
        Parent root = FXMLLoader.load(xmlUrl);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene sc = new Scene(root);
        stage.setScene(sc);

    }

    @FXML
    void setBtnMovieTheme() {
        btnSportTheme.setVisible(false);
        btnMovieTheme.setVisible(false);
        labelTheme.setText("Выберите вариант ответа");
        isMovieTheme = true;
        getMovieQuestion();
        qIndex = 0;

    }

    public void getMovieQuestion() {
        dbService = new DBService();
        questionScore = 0;
        totalScore = 0;

        try {
            List<MovieTheme> movieTheme = dbService.getMovieTheme(1);
            System.out.println(movieTheme);
            Collections.shuffle(movieTheme);
            Theme movieQuestion = movieTheme.get(qIndex);
            int questionId = movieQuestion.getId();
            System.out.println(questionId);
            questTheme.setText(movieQuestion.getQuestion());
            rightAnswer = movieQuestion.getAnswer(); //записываем правильный ответ;
            questionScore = movieQuestion.getPoint(); //записываем балл ответа;
            System.out.println(rightAnswer);
            List<String> answers = new ArrayList<>();
            answers.add(movieQuestion.getAnswer());
            answers.add(movieQuestion.getWrongAnswer1());
            answers.add(movieQuestion.getWrongAnswer2());
            answers.add(movieQuestion.getWrongAnswer3());
            Collections.shuffle(answers);

            answer1.setText(answers.get(0));
            answer2.setText(answers.get(1));
            answer3.setText(answers.get(2));
            answer4.setText(answers.get(3));

        } catch (SQLException e) {
            e.printStackTrace();


        }
    }


    @FXML
    void setBtnSportTheme() {
        btnMovieTheme.setVisible(false);
        btnSportTheme.setVisible(false);
        labelTheme.setText("Выберите вариант ответа");
        isSportTheme=true;
        getSportQuestion();
        qIndex = 0;


    }

    public void getSportQuestion() {
        dbService = new DBService();
        questionScore = 0;
        totalScore = 0;
        //вывод вопросов по выбранной теме
        try {
            List<SportLegendTheme> sportLegendTheme = dbService.getSportTheme(2);
            System.out.println(sportLegendTheme);
            Collections.shuffle(sportLegendTheme);
            Theme sportQuestion = sportLegendTheme.get(qIndex);
            int questionId = sportQuestion.getId();
            System.out.println(questionId);
            questTheme.setText(sportQuestion.getQuestion());
            rightAnswer = sportQuestion.getAnswer(); //записываем правильный ответ;
            questionScore = sportQuestion.getPoint(); //записываем балл ответа;
            System.out.println(rightAnswer);
            List<String> answers = new ArrayList<>();
            answers.add(sportQuestion.getAnswer());
            answers.add(sportQuestion.getWrongAnswer1());
            answers.add(sportQuestion.getWrongAnswer2());
            answers.add(sportQuestion.getWrongAnswer3());
            Collections.shuffle(answers);

            answer1.setText(answers.get(0));
            answer2.setText(answers.get(1));
            answer3.setText(answers.get(2));
            answer4.setText(answers.get(3));

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

//выбор ответов:
        @FXML
        void clickAnswer1 () {
            if (answer1.getText().equals(rightAnswer)) {
                answer1.setStyle("-fx-background-color: #9ACD32;");
                isRight = true;
            } else {
                answer1.setStyle("-fx-background-color: #FA8072;");
            }
            answer1.setDisable(true);
            answer2.setDisable(true);
            answer3.setDisable(true);
            answer4.setDisable(true);

        }

        @FXML
        void clickAnswer2 () {
            if (answer2.getText().equals(rightAnswer)) {
                answer2.setStyle("-fx-background-color: #9ACD32;");
                isRight = true;
            } else {
                answer2.setStyle("-fx-background-color: #FA8072;");
            }
            answer1.setDisable(true);
            answer2.setDisable(true);
            answer3.setDisable(true);
            answer4.setDisable(true);

        }


        @FXML
        void clickAnswer3 () {
            if (answer3.getText().equals(rightAnswer)) {
                answer3.setStyle("-fx-background-color: #9ACD32;");
                isRight = true;
            } else {
                answer3.setStyle("-fx-background-color: #FA8072;");
            }
            answer1.setDisable(true);
            answer2.setDisable(true);
            answer3.setDisable(true);
            answer4.setDisable(true);

        }

        @FXML
        void clickAnswer4 () {
            if (answer4.getText().equals(rightAnswer)) {
                answer4.setStyle("-fx-background-color: #9ACD32;");
                isRight = true;
            } else {
                answer4.setStyle("-fx-background-color: #FA8072;");
            }
            answer1.setDisable(true);
            answer2.setDisable(true);
            answer3.setDisable(true);
            answer4.setDisable(true);

        }

        @FXML
        void clickNext() {
            answer1.setDisable(false);
            answer2.setDisable(false);
            answer3.setDisable(false);
            answer4.setDisable(false);
            answer1.setStyle("-fx-background-color: #B0E0E6;");
            answer2.setStyle("-fx-background-color: #B0E0E6;");
            answer3.setStyle("-fx-background-color: #B0E0E6;");
            answer4.setStyle("-fx-background-color: #B0E0E6;");
            qIndex++;

            if (isRight = true) {
                totalScore = questionScore++;
                System.out.println(totalScore);


            } else {
                System.out.println(totalScore);
            }

            if(isMovieTheme=true) {
                getMovieQuestion();
                isSportTheme = false;
            }

            if(isSportTheme = true) {
                getSportQuestion();
                isMovieTheme=false;
            }

        }

}
