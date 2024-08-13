import com.twilio.twiml.VoiceResponse;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TwilioParameterNameExample {

    public static void main(String[] args) {

        Stream<Method> methods = Arrays.stream(VoiceResponse.Builder.class.getDeclaredMethods()).filter( method ->
                !method.getName().equals("fromXml") && !method.getName().equals("build")
        ).sorted(Comparator.comparing(Method::getName));

        methods.forEach(method -> {
                    String params = Arrays.stream(method.getParameters()).map(parameter ->
                            parameter.getType().getSimpleName() + " " + parameter.getName()
                    ).collect(Collectors.joining(", "));
                    System.out.println(method.getName() + "(" + params + ")");
                }
        );
    }
}
