package at2.ivanov.nikita.homework.service;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnBean(OnlyTestProfileService.class)
public class WhenTestCreatedService extends DefaultClass{
}
