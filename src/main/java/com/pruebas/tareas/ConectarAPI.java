package com.pruebas.tareas;

import com.pruebas.utilidades.Constantes;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConectarAPI implements Task {

    @Override
    @Step("{0} se conecta al API")
    public <T extends Actor> void performAs(T actor) {
        actor.whoCan(CallAnApi.at(Constantes.URL_BASE));
    }

    public static ConectarAPI alServicio() {
        return instrumented(ConectarAPI.class);
    }
}