package repositories;

import entities.Measurement;
import play.db.jpa.JPAApi;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.concurrent.CompletableFuture.supplyAsync;

/**
 * @author CaTaLiS
 */
public class JPAMeasurementRepository implements MeasurementRepository {

    private final JPAApi jpaApi;
    private final DatabaseExecutionContext databaseExecutionContext;

    @Inject
    public JPAMeasurementRepository(JPAApi jpaApi, DatabaseExecutionContext databaseExecutionContext) {
        this.jpaApi = jpaApi;
        this.databaseExecutionContext = databaseExecutionContext;
    }

    @Override
    public CompletionStage<Measurement> add(Measurement measurement) {
        return supplyAsync(() -> wrap(em -> insert(em, measurement)), databaseExecutionContext);
    }

    @Override
    public CompletionStage<Stream<Measurement>> list() {
        return supplyAsync(() -> wrap(em -> list(em)), databaseExecutionContext);
    }

    private <T> T wrap(Function<EntityManager, T> function) {
        return jpaApi.withTransaction(function);
    }

    private Measurement insert(EntityManager em, Measurement measurement) {
        em.persist(measurement);
        return measurement;
    }

    private Stream<Measurement> list(EntityManager em) {
        List<Measurement> measurements = em.createQuery("SELECT m FROM Measurement m", Measurement.class).getResultList();
        return measurements.stream();
    }
}
