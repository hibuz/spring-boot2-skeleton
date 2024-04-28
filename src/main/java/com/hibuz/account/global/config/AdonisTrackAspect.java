package com.hibuz.account.global.config;

import com.woozooha.adonistrack.aspect.ProfileAspect;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.io.File;

@Aspect
@Component
public class AdonisTrackAspect extends ProfileAspect {

    @Pointcut("execution(* *(..)) && (within(com.hibuz.account..*)) && !within(com.hibuz.account.global.config..*)")
    public void executionPointcut() {
    }

    @Override
    protected boolean useMemoryWriter() {
        return false;
    }

    @Override
    protected boolean useFileWriter() {
        return true;
    }

    @Override
    protected File getFileWriterRootDir() {
        return new File("./adonis-track");
    }
}