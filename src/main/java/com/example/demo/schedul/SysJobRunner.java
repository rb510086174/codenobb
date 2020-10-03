package com.example.demo.schedul;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class SysJobRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(SysJobRunner.class);

//    @Autowired
//    private ISysJobRepository sysJobRepository;

    @Autowired
    private CronTaskRegistrar cronTaskRegistrar;

    @Override
    public void run(String... args) {
        // 初始加载数据库里状态为正常的定时任务
//        List<SysJobPO> jobList = sysJobRepository.getSysJobListByStatus(SysJobStatus.NORMAL.ordinal());
        List<SysJobPO> jobList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(jobList)) {
            for (SysJobPO job : jobList) {
                SchedulingRunnable task = new SchedulingRunnable(job.getBeanName(), job.getMethodName(), job.getMethodParams());
                cronTaskRegistrar.addCronTask(task, job.getCronExpression());
            }

            logger.info("定时任务已加载完毕...");
        }
    }

//    public boolean add(){
//        boolean success = sysJobRepository.addSysJob(sysJob);
//        if (!success)
//            return OperationResUtils.fail("新增失败");
//        else {
//            if (sysJob.getJobStatus().equals(SysJobStatus.NORMAL.ordinal())) {
//                SchedulingRunnable task = new SchedulingRunnable(sysJob.getBeanName(), sysJob.getMethodName(), sysJob.getMethodParams());
//                cronTaskRegistrar.addCronTask(task, sysJob.getCronExpression());
//            }
//        }
//
//        return OperationResUtils.success();
//    }
}