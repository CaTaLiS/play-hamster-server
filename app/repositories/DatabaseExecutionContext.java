package repositories;

import scala.concurrent.ExecutionContext;
import scala.concurrent.ExecutionContextExecutor;

import javax.inject.Inject;

/**
 * @author CaTaLiS
 */
public class DatabaseExecutionContext implements ExecutionContextExecutor {

    private final ExecutionContext executionContext;

    private static final String name = "database.dispatcher";

    @Inject
    public DatabaseExecutionContext(ExecutionContext executionContext) {
        this.executionContext = executionContext;
    }

    @Override
    public void execute(Runnable runnable) {
        executionContext.execute(runnable);
    }

    @Override
    public void reportFailure(Throwable cause) {
        executionContext.reportFailure(cause);
    }

    @Override
    public ExecutionContext prepare() {
        return executionContext.prepare();
    }
}
