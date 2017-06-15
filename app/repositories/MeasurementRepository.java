package repositories;

import com.google.inject.ImplementedBy;
import entities.Measurement;

import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;

/**
 * @author CaTaLiS
 */
@ImplementedBy(JPAMeasurementRepository.class)
public interface MeasurementRepository {

    CompletionStage<Measurement> add(Measurement measurement);

    CompletionStage<Stream<Measurement>> list();

}
