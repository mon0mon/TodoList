package xyz.mon0mon.todolistbackend.member.conveter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.Arrays;
import xyz.mon0mon.todolistbackend.member.entity.OAuthActive;

@Converter(autoApply = true)
public class OAuthActiveConverter implements
        AttributeConverter<OAuthActive, Integer> {
    @Override
    public Integer convertToDatabaseColumn(OAuthActive oAuthActive) {
        return oAuthActive.getCode();
    }

    @Override
    public OAuthActive convertToEntityAttribute(Integer integer) {
        return Arrays.stream(OAuthActive.values())
                .filter(itr -> itr.getCode().equals(integer))
                .findAny()
                .orElse(OAuthActive.NONE);
    }
}
