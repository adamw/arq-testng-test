package pl.softwaremill.arqtest;

import org.jboss.arquillian.api.Deployment;
import org.jboss.shrinkwrap.api.spec.JavaArchive;

/**
 * @author Adam Warski (adam at warski dot org)
 */
public class Test1 extends AbstractTest{
    @Deployment
    public static JavaArchive createTestArchive() {
        return AbstractTest.createTestArchive();
    }

    @Override
    protected String testTestClassId() {
        return "test1";
    }
}
