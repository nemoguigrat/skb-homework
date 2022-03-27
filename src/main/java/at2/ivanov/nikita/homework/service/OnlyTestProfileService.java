package at2.ivanov.nikita.homework.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("test")
public class OnlyTestProfileService extends DefaultClass{
}
