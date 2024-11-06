package com.pruebas.tareas;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsumirServicioFallido implements Task {

    @Override
    @Step("{0} consulta un recurso inexistente para provocar un error")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/recursos_inexistentes")
        );
    }

    public static ConsumirServicioFallido conError() {
        return instrumented(ConsumirServicioFallido.class);
    }
}
