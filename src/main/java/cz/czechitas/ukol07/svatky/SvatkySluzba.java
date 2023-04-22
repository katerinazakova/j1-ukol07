package cz.czechitas.ukol07.svatky;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.MonthDayDeserializer;

import java.io.IOException;
import java.nio.file.Path;
import java.time.MonthDay;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SvatkySluzba {

    private final ObjectMapper objectMapper = JsonMapper.builder()
            .addModule(new JavaTimeModule())
            .build();
    private final Path cestaKDatum = Path.of("svatky.json");
    private final SeznamSvatku seznamSvatku;


    public SvatkySluzba() throws IOException {
        // TODO načíst seznam svátků ze souboru svatky.json

        // Následující řádek po vlastní implementaci smažete.
        seznamSvatku = objectMapper.readValue((JsonParser) cestaKDatum,SeznamSvatku.class);

    }

    public List<String> vyhledatSvatkyDnes() {
        return vyhledatSvatkyKeDni(MonthDay.now());
    }

    public List<String> vyhledatSvatkyKeDni(MonthDay day) {
        List <SeznamSvatku> svatkyKeDni = new ArrayList<>(Arrays.asList(seznamSvatku));
            String seznamSvatkyKeDni = svatkyKeDni.stream()
                .filter(svatek -> svatek.getSvatky().equals(MonthDay)
                .map(Svatek::getJmeno)
                .collect(Collectors.toList());


        // TODO
        // získat seznam svátků
        // převést na Stream
        // pomocí metody filter() vybrat jen ty, které odpovídají zadanému dni (porovnat MonthDay pomocí metodyequals())
        // pomocí metody map() získat z objektu jméno
        // pomocí toList() převést na List

        // Následující řádek po vlastní implementaci smažete.
        return List.of();
    }
}
