package drk.apps.domain.service;

import drk.apps.infrastructure.db.ArticleDBRepository;
import drk.apps.infrastructure.models.Article;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Set;

@ApplicationScoped
public class ArticleService {

    @Inject
    ArticleDBRepository repository;

    public Article save(Article dataToSave) {
        return this.repository.save(dataToSave);
    }
    public Set<Article> getAll () {
        return this.repository.getAll();
    }
}
