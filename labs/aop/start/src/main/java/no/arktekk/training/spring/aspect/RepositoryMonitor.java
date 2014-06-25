package no.arktekk.training.spring.aspect;

import com.sun.org.apache.xpath.internal.SourceTree;
import com.sun.xml.internal.ws.message.saaj.SAAJHeader;
import no.arktekk.training.spring.monitor.Monitor;
import no.arktekk.training.spring.monitor.MonitorFactory;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author <a href="mailto:kaare.nilsen@arktekk.no">Kaare Nilsen</a>
 */
@Aspect
public class RepositoryMonitor {
    private final MonitorFactory monitorFactory;

    public RepositoryMonitor(MonitorFactory monitorFactory) {
        this.monitorFactory = monitorFactory;
    }
    @Pointcut("execution(public * no.arktekk.training.spring.repository..*(..))")
    public void allPublicAuctionRepositoryMethods() {
        System.out.println("jello void");
        
    }

    @Around("allPublicAuctionRepositoryMethods()")
    public Object monitor(ProceedingJoinPoint method) throws Throwable {
        Monitor monitor = monitorFactory.monitor(createMonitorName(method));
        try {
            monitor.start();
            return method.proceed();
        } finally {
            monitor.stop();
            System.out.println("monitor = " + monitor);
        }

    }

    private String createMonitorName(ProceedingJoinPoint method) {
        return method.getSignature().getDeclaringTypeName() + "." + method.getSignature().getName();
    }

}
