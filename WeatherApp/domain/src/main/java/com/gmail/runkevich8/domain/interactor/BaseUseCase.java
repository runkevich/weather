package com.gmail.runkevich8.domain.interactor;


import com.gmail.runkevich8.domain.executor.PostExecutionThread;
import com.gmail.runkevich8.domain.executor.ThreadExecutor;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public abstract class BaseUseCase {
    protected Scheduler postExecuteionThread;

    protected Scheduler threadExecuteion;


    public BaseUseCase(PostExecutionThread postExecutionThread,ThreadExecutor threadExecuteion){

        this.postExecuteionThread = postExecutionThread.getScheduler();
        this.threadExecuteion = Schedulers.from(threadExecuteion);
    }
}
