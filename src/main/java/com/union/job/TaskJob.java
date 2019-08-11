package com.union.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2019/7/16.
 */
@Service
public class TaskJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        System.out.println("定时任务在执行...");
        System.out.println("JobExecutionContext:   "+context);

    }
}
