package io.javabrains.reactiveworkshop;


public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        System.out.println("Print all numbers in the intNumbersStream stream");
        StreamSources.intNumbersStream().
                forEach(System.out::println);

        // Print numbers from intNumbersStream that are less than 5
        System.out.println("Print numbers from intNumbersStream that are less than 5");
        StreamSources.intNumbersStream().
                filter(number -> number < 5).
                forEach(number -> System.out.println(number));

        // Print the second and third numbers in intNumbersStream that's greater than 5
        System.out.println("Print the second and third numbers in intNumbersStream that's greater than 5");
        StreamSources.intNumbersStream().filter(number -> number > 5).
                skip(1).
                limit(2).
                forEach(number -> System.out.println(number));

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        System.out.println("Print the first number in intNumbersStream that's greater than 5.");
        Integer value = StreamSources.intNumbersStream().filter(number -> number > 5).
                findFirst().
                orElse(-1);
        System.out.println(value);


        // Print first names of all users in userStream
        System.out.println("Print first names of all users in userStream");
        StreamSources.userStream().
                map(user -> user.getFirstName()).
                forEach(userName -> System.out.println(userName));

        // Print first names in userStream for users that have IDs from number stream
        System.out.println("Print first names in userStream for users that have IDs from number stream");
        StreamSources.intNumbersStream()
                .flatMap(id -> StreamSources.userStream().filter(user -> user.getId() == id))
                .map(user -> user.getFirstName())
                .forEach(userName -> System.out.println(userName));


    }

}
