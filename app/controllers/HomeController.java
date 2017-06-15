package controllers;

import entities.Measurement;
import play.data.FormFactory;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.*;

import repositories.MeasurementRepository;
import views.html.*;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static play.libs.Json.toJson;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    private final FormFactory formFactory;
    private final MeasurementRepository measurementRepository;
    private final HttpExecutionContext httpExecutionContext;

    @Inject
    public HomeController(FormFactory formFactory, MeasurementRepository measurementRepository, HttpExecutionContext httpExecutionContext) {
        this.formFactory = formFactory;
        this.measurementRepository = measurementRepository;
        this.httpExecutionContext = httpExecutionContext;
    }

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        final CompletionStage<Stream<Measurement>> list = measurementRepository.list();
        return ok(index.render("Your new application is ready."));
    }

    public CompletionStage<Result> getMeasurements() {
        return measurementRepository.list().thenApplyAsync(measurementStream -> {
            return ok(toJson(measurementStream.collect(Collectors.toList())));
        }, httpExecutionContext.current());
    }

}
