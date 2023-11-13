package com.ll.global.app;

import com.ll.domain.quote.quote.entity.Quote;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private final Scanner scanner;

    public App(final Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        System.out.println("== 명언 앱 ==");

        final List<Quote> quoteList = new ArrayList<>();
        long lastQuoteId = 0;

        while (true) {
            final String cmd = scanner.nextLine().trim();

            switch (cmd) {
                case "등록" ->{
                    System.out.println("명언 : ");
                    final String content = scanner.nextLine().trim();
                    System.out.println("작가 : ");
                    final String authorName = scanner.nextLine().trim();

                    final long id = ++lastQuoteId;

                    Quote quote = new Quote(id, authorName, content);
                    quoteList.add(quote);

                    System.out.println("%d번 명언이 등록되었습니다.".formatted(id));
                }
                case "목록" ->{
                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("--------------------");
                    quoteList
                            .reversed()
                            .forEach(quote ->
                                    System.out.println(
                                            "%d / %s / %s".formatted(
                                                    quote.getId(),
                                                    quote.getAuthorName(),
                                                    quote.getContent())));
                }
                case "종료" -> {
                    return;
                }
            }
        }
    }
}
