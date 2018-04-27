package com.mapper.driver;

import com.google.common.base.CaseFormat;
import com.mapper.annotation.Invisible;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.scripting.LanguageDriver;
import org.apache.ibatis.scripting.xmltags.XMLLanguageDriver;
import org.apache.ibatis.session.Configuration;

import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by h on 2018/4/28.
 */
public class SimpleUpdateExtendedLanguageDriver
        extends XMLLanguageDriver implements LanguageDriver {
    private final Pattern inPattern = Pattern.compile("\\(#\\{(\\w+)\\}\\)");

    @Override
    public SqlSource createSqlSource(Configuration configuration, String script, Class<?> parameterType) {
        Matcher matcher = inPattern.matcher(script);
        if (matcher.find()) {
            StringBuilder sb = new StringBuilder();
            sb.append("<set>");
            for (Field field : parameterType.getDeclaredFields()) {
                if (!field.isAnnotationPresent(Invisible.class)) {
                    String temp = "<if test=\"__field != null\">__column=#{__field},</if>";
                    sb.append(temp.replaceAll("__field", field.getName())
                            .replaceAll("__column", CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, field.getName())));
                }
            }

            sb.deleteCharAt(sb.lastIndexOf(","));
            sb.append("</set>");

            script = matcher.replaceAll(sb.toString());

            script = "<script>" + script + "</script>";
        }
        return super.createSqlSource(configuration, script, parameterType);
    }
}
