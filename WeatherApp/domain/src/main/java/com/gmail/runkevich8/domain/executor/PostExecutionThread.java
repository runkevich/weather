package com.gmail.runkevich8.domain.executor;

import io.reactivex.Scheduler;



public interface PostExecutionThread {

    Scheduler getScheduler();
}
