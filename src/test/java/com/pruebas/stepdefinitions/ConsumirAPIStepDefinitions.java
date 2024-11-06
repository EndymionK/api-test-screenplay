package com.pruebas.stepdefinitions;

import com.pruebas.preguntas.ValidacionRespuesta;
import com.pruebas.tareas.ConectarAPI;
import com.pruebas.tareas.ConsumirServicio;
import com.pruebas.tareas.ConsumirServicioFallido;
import io.cucumber.java.es.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import io.cucumber.java.Before;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.*;

public class ConsumirAPIStepDefinitions {

    private Actor usuario = Actor.named("Usuario API");

    @Before
    public void prepararEscenario() {
        OnStage.setTheStage(new OnlineCast());
    }

    // Camino "feliz"
    @Dado("que me encuentro conectado al servicio")
    public void meEncuentroConectadoAlServicio() {
        usuario.attemptsTo(
                ConectarAPI.alServicio()
        );
    }

    @Cuando("consulto la información de usuarios")
    public void consultoInformacionUsuarios() {
        usuario.attemptsTo(
                ConsumirServicio.usuarios()
        );
    }

    @Entonces("debería obtener un código de respuesta exitoso {int}")
    public void deberiaObtenerCodigoRespuesta(Integer codigo) {
        usuario.should(
                seeThat("el código de respuesta", ValidacionRespuesta.codigo(), equalTo(codigo))
        );
    }

    @Y("la respuesta debería contener datos de usuarios")
    public void laRespuestaDeberiaContenerDatosUsuarios() {
        usuario.should(
                seeThat("el cuerpo de la respuesta", ValidacionRespuesta.cuerpo(), notNullValue())
        );
    }

    // Camino "triste"
    @Cuando("intento consultar un recurso inexistente")
    public void consultoRecursoInexistente() {
        usuario.attemptsTo(
                ConsumirServicioFallido.conError()
        );
    }

    @Entonces("debería obtener un código de respuesta fallido {int}")
    public void deberiaObtenerCodigoDeError(Integer codigoError) {
        usuario.should(
                seeThat("el código de error", ValidacionRespuesta.codigo(), equalTo(codigoError))
        );
    }

    @Y("la respuesta debería indicar que el recurso no fue encontrado")
    public void laRespuestaDeberiaIndicarUnError() {
        usuario.should(
                seeThat("el cuerpo de la respuesta", ValidacionRespuesta.cuerpo(), containsString("{}"))
        );
    }
}
