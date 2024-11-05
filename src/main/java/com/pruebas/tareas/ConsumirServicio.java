package com.pruebas.tareas;

import com.pruebas.utilidades.Constantes;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsumirServicio implements Task {

    @Override
    @Step("{0} consulta los usuarios")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(Constantes.RECURSO_USUARIOS)
        );
    }

    public static ConsumirServicio usuarios() {
        return instrumented(ConsumirServicio.class);
    }
}
