package widgets;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class DataProvider {

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("Gandalf Grey", "test@o2.pl", "testtest"),
                Arguments.of("Frodo", "Frodo@o2.pl", "Frodttest"),
                Arguments.of("Legolas", "Legolas@o2.pl", "Legottest")
        );
    }
}
