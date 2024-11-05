package com.pruebas.preguntas;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;

public class ValidacionRespuesta {

    public static Question<Integer> codigo() {
        return actor -> SerenityRest.lastResponse().statusCode();
    }

    public static Question<String> cuerpo() {
        return actor -> SerenityRest.lastResponse().body().asString();
    }
}