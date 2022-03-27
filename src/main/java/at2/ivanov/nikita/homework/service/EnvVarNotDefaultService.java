package at2.ivanov.nikita.homework.service;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnExpression("'${homework.env}' != 'default'")
public class EnvVarNotDefaultService extends DefaultClass {
}
