package drk.apps.application.services;

import drk.apps.application.inter.ArticleApplicationInterface;
import drk.apps.domain.service.ArticleService;
import drk.apps.infrastructure.models.Article;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Set;

@ApplicationScoped
public class ArticleUseCase implements ArticleApplicationInterface {

    @Inject
    ArticleService service;

    @Override
    public Article save(Article dataToSave) {
        return this.service.save(dataToSave);
    }

    @Override
    public Set<Article> getAll() {
        return this.service.getAll();
    }
}
