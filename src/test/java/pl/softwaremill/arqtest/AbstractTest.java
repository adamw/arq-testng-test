package pl.softwaremill.arqtest;

import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.ByteArrayAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import javax.inject.Inject;

/**
 * @author Adam Warski (adam at warski dot org)
 */
public abstract class AbstractTest {
    @Inject
    private Bean1 bean1;

    @Inject
    private Bean1 bean2;

    public static JavaArchive createTestArchive() {
        JavaArchive ar = ShrinkWrap.create(JavaArchive.class)
                .addPackage(Bean1.class.getPackage());

        return ar.addManifestResource(
                new ByteArrayAsset("<beans></beans>".getBytes()),
                ArchivePaths.create("beans.xml"));
    }


    protected abstract String testTestClassId();

    @Test
    public void dummyTestA() {
        System.out.println("Dummy test A for: " + testTestClassId());
    }

    @Test(dependsOnMethods = "dummyTestA")
    public void dummyTestB() {
        System.out.println("Dummy test B for: " + testTestClassId());
    }

    @AfterClass
    public void after() {
        System.out.println("After:            " + testTestClassId());
    }
}
