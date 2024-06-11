//package com.surup.triptogather.batch;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobScope;
//import org.springframework.batch.core.configuration.annotation.StepScope;
//import org.springframework.batch.core.job.builder.JobBuilder;
//import org.springframework.batch.core.repository.JobRepository;
//import org.springframework.batch.core.step.builder.StepBuilder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.transaction.PlatformTransactionManager;
//
//@Configuration
//@EnableBatchProcessing
//public class KTOTBatch {
//
//    @Autowired
//    private JobRepository jobRepository;
//
//    @Bean
//    public Job insertTourApiJob(JobRepository jobRepository, Step step) {
//        return new JobBuilder("insertTourApiJob", jobRepository)
//                .start(step)
//                .build();
//    }
//
//    @Bean
//    @JobScope
//    public Step insertTourApiStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
//        return new StepBuilder("insertTourApiStep", jobRepository)
//                .chunk(10, transactionManager)
//                .build();
//    }
//
//    @Bean
//    @StepScope
//    public
//
//}
