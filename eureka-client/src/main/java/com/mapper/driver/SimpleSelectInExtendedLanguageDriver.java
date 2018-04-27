package com.mapper.driver;

import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.scripting.LanguageDriver;
import org.apache.ibatis.scripting.xmltags.XMLLanguageDriver;
import org.apache.ibatis.session.Configuration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by h on 2018/4/28.
 */
public class SimpleSelectInExtendedLanguageDriver
        extends XMLLanguageDriver implements LanguageDriver {
    private final Pattern inPattern = Pattern.compile("\\(#\\{(\\w+)\\}\\)");

    @Override
    public SqlSource createSqlSource(Configuration configuration, String script, Class<?> parameterType) {
        Matcher matcher = inPattern.matcher(script);
        if (matcher.find()) {
            script = matcher.replaceAll("(<foreach collection=\"$1\" item=\"__item\" separator=\",\" >#{__item}</foreach>)");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<script>").append(script).append("</script>");
        return super.createSqlSource(configuration, sb.toString(), parameterType);
    }
}
