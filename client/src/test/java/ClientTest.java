import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;
import io.github.lukehutch.fastclasspathscanner.scanner.ScanResult;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ClientTest {

    @Test
    public void unsociable_test() {
        ServerComponent.doSomethingShiny();
        assertThat(true).isTrue();
    }

    @Test
    public void test_runner_classpath_contains_tests_of_all_submodules() {
        ScanResult scanResult = new FastClasspathScanner()
                .enableMethodAnnotationIndexing()
                .scan();
        List<String> classes = scanResult.getNamesOfClassesWithMethodAnnotation(Test.class);
        assertThat(classes).contains(ServerTest.class.getName());
        assertThat(classes).contains(ClientTest.class.getName());
    }

}
