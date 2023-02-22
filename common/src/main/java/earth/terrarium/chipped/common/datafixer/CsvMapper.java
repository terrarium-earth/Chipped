package earth.terrarium.chipped.common.datafixer;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class CsvMapper implements Function<String, String> {

    private final String id;
    private final Map<String, String> renameMap = new HashMap<>();

    public CsvMapper(String csv, String id) {
        this.id = id;
        String lastValue = null;
        for (String s : csv.split("\\R")) {
            String[] split = split(s, lastValue);
            renameMap.put(split[0], split[1]);
            lastValue = split[1];
        }
    }

    private static String[] split(String s, String backup) {
        String[] split = s.split(",");
        if (split.length == 1) {
            return new String[]{split[0], backup};
        }
        if (split.length == 2) {
            return new String[]{split[0], split[1]};
        }
        throw new IllegalArgumentException("Invalid Data Fixer CSV: " + s);
    }

    public String displayName() {
        return String.format("Rename blocks: %s", id);
    }

    @Override
    public String apply(String s) {
        return renameMap.getOrDefault(s, s);
    }
}
