package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Flux;

import java.io.IOException;

public class Exercise8 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFluxWithException()

        // Print values from intNumbersFluxWithException and print a message when error happens
        ReactiveSources.intNumbersFluxWithException().subscribe(number -> System.out.println(number),
                err -> System.out.println(err.getMessage()));

        ReactiveSources.intNumbersFluxWithException().
                doOnError(err -> System.out.println("Error !!" + err.getMessage())).
                subscribe(number -> System.out.println(number));

        // Print values from intNumbersFluxWithException and continue on errors
        ReactiveSources.intNumbersFluxWithException().
                onErrorContinue((e, item) -> System.out.println("Error !!" + e.getMessage())).
                subscribe(number -> System.out.println(number));

        // Print values from intNumbersFluxWithException and when errors
        // happen, replace with a fallback sequence of -1 and -2
        ReactiveSources.intNumbersFluxWithException().
                onErrorResume(err -> Flux.just(-1, -2)).
                subscribe(number -> System.out.println(number));

        System.out.println("Press a key to end");
        System.in.read();
    }

}
