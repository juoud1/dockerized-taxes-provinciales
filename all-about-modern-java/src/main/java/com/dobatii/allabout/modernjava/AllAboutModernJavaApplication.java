package com.dobatii.allabout.modernjava;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class AllAboutModernJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AllAboutModernJavaApplication.class, args);
		
		log.info("Allo".toUpperCase());
		
		String dobatiiContents = StringUtils.EMPTY;
		try {
			dobatiiContents = new String(Files.readAllBytes(Paths.get("dobatii.txt")), StandardCharsets.UTF_8);
			log.info("dobatiiContents : {}", dobatiiContents);
		} catch (IOException e) {
			log.error(e.getMessage().toUpperCase());
		}
		
		log.info("Stream creation".toUpperCase());
		Stream<String> streamSilence = Stream.empty();
		log.info("silence {}", streamSilence); 
		
		Stream<String> streamStrings = Stream.of("Dongongo", "dobatii", "doway");
		log.info("streamStrings : {}", streamStrings);
		
		Stream<String> streamGenerateString = Stream.generate(() -> "Allo Dongongo");
		log.info("streamGenerateString : {}", streamGenerateString);
		
		Stream<Double> streamGenerateDouble = Stream.generate(Math::random);
		log.info("streamGenerateDouble : {}", streamGenerateDouble);
		
		Stream<BigDecimal> streamIterateBigDecimal = Stream.iterate(BigDecimal.ZERO, n -> n.add(BigDecimal.TEN));
		log.info("streamBigDecimal : {}", streamIterateBigDecimal);
		
		log.info("Stream transformation : reads stream from a stream and puts the transformed data into another stream.".toUpperCase());
		Stream<String> streamStringsFilter = streamStrings.filter(n -> n.length()>6);
		log.info("streamStringsFilter : {}", streamStringsFilter);
		
		Stream<BigDecimal> streamIterateBigDecimalFilter = streamIterateBigDecimal.filter(n -> n.doubleValue() % 11 == 0);
		log.info("streamIterateBigDecimalFilter : {}", streamIterateBigDecimalFilter);
		
		Stream<String> streamStringsMap = streamStringsFilter.map(String::toUpperCase);
		log.info("streamStringsMap : {}", streamStringsMap);
		
		log.info("Extracting Subsstream and combined streams.".toUpperCase());
		Stream<BigDecimal> streamIterateBigDecimalLimit = Stream.iterate(BigDecimal.ZERO, n -> n.add(BigDecimal.TEN)).limit(78);
		log.info("streamIterateBigDecimalLimit : {}", streamIterateBigDecimalLimit);
		
		Stream<String> streamStringsConcat = Stream.concat(Stream.of("Dongongo", "Doway"), Stream.generate(() -> "Dobatii"));
		log.info("streamStringsConcat : {}", streamStringsConcat);
		
		log.info("Simple reductions of streams.".toUpperCase());
		log.info("streamSilence.count : {}", streamSilence.count());
		log.info("streamStrings.count : {}", Stream.of("Dongongo", "dobatii", "doway").count());
		log.info("streamGenerateString.max : {}", Stream.generate(() -> "Allo Dongongo").limit(100).max(String::compareToIgnoreCase).get());
		log.info("streamGenerateDouble.max : {}", streamGenerateDouble.limit(100).max(Double::compareTo).get());
		log.info("streamIterateBigDecimal.max : {}", Stream.iterate(BigDecimal.ZERO, n -> n.add(BigDecimal.TEN)).limit(100).max(BigDecimal::compareTo).get());
		log.info("streamStringsFilter.max : {}", Stream.of("Dongongo", "dobatii", "doway").filter(n -> n.length()>6).limit(100).max(String::compareToIgnoreCase).get());
		log.info("streamIterateBigDecimalFilter.max : {}", Stream.iterate(BigDecimal.ZERO, n -> n.add(BigDecimal.TEN)).filter(n -> n.doubleValue() % 11 == 0).limit(100).max(BigDecimal::compareTo).get());
		log.info("streamStringsMap.max : {}", Stream.of("Dongongo", "dobatii", "doway").map(String::toUpperCase).limit(100).max(String::compareToIgnoreCase).get());
//		log.info("streamIterateBigDecimalLimit.max : {}", streamIterateBigDecimalLimit.limit(100).max(BigDecimal::compareTo).get());
//		log.info("streamStringsConcat.max : {}", streamStringsConcat.limit(100).max(String::compareToIgnoreCase).get());
		log.info("findfirst : {}", Stream.of("Dobatii", "Dongongo", "Doway", "Dodo").findFirst());
		log.info("findfirst : {}", Stream.of("Dobatii", "Dongongo", "Doway", "Dodo").findAny());
		log.info("filter and findfirst : {}", Stream.of("Dobatii", "Dongongo", "Doway", "Dodo").filter(s -> s.endsWith("o")).findFirst());
		log.info("filter and findfirst : {}", Stream.of("Dobatii", "Dongongo", "Doway", "Dodo").parallel().filter(s -> s.endsWith("o")).findFirst());
		log.info("filter and findAny : {}", Stream.of("Dobatii", "Dongongo", "Doway", "Dodo").parallel().filter(s -> s.endsWith("o")).findAny());
		
		log.info("reductions operations : compute a sum".toUpperCase());
		log.info("reduce a stream of double as sum : {}", Stream.iterate(BigDecimal.ONE, n -> n.add(BigDecimal.TEN))
				.limit(78)
				.map(BigDecimal::doubleValue)
				.reduce((x, y) -> x + y)
				.orElse(0d));
		log.info("reduce a stream of double as product : {}", Stream.iterate(BigDecimal.ONE, n -> n.add(BigDecimal.TEN))
				.limit(78)
				.map(BigDecimal::doubleValue)
				.reduce((x, y) -> x * y));
		
		log.info("reduce a stream of double as sum with identity : {}", Stream.iterate(BigDecimal.ONE, n -> n.add(BigDecimal.TEN))
				.limit(78)
				.map(BigDecimal::doubleValue)
				.reduce(0d, (x, y) -> x + y));
		log.info("reduce a stream of double as product with identity : {}", Stream.iterate(BigDecimal.ONE, n -> n.add(BigDecimal.TEN))
				.limit(78)
				.map(BigDecimal::doubleValue)
				.reduce(BigDecimal.ONE.doubleValue(), (x, y) -> x * y));
		
		Stream<String> streamIsoCountries = Stream.of(Locale.getISOCountries());
		log.info("sorted countries list: {}", streamIsoCountries.sorted().collect(Collectors.toList()));
		log.info("sorted countries count: {}", Stream.of(Locale.getISOCountries()).sorted().count());
		log.info("sorted Locale list : {}", Stream.of(Locale.getAvailableLocales()).sorted((x, y) -> x.getDisplayName().compareTo(x.getDisplayName())).collect(Collectors.toList()));
		log.info("sorted Locale count : {}", Stream.of(Locale.getAvailableLocales()).count());
		log.info("sorted Locale group by language : {}", Stream.of(Locale.getAvailableLocales())
				.sorted((x, y) -> x.getDisplayLanguage().compareToIgnoreCase(y.getDisplayLanguage()))
				.collect(Collectors.groupingBy(x -> x.getDisplayLanguage())));
		log.info("sorted Locale language : {}", Stream.of(Locale.getAvailableLocales())
				.map(x -> x.getDisplayLanguage())
				.distinct()
				.sorted((x, y) -> Integer.compare(x.length(), y.length()))
				.collect(Collectors.toList()));
	}

	@Bean
	public ApplicationRunner doRun() {
		return null;
	}
}
