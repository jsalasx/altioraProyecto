package drk.apps.infrastructure.db;

import drk.apps.infrastructure.models.Article;
import drk.apps.infrastructure.models.Client;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.HashSet;
import java.util.Set;

@ApplicationScoped
public class ArticleDBRepository implements PanacheRepository<Article> {

    @Transactional
    public Article save(Article entity) {
        persist(entity);
        return  entity;
    }

    public Set<Article> getAll() {
        Set<Article> set = new HashSet<>(listAll());
        return set;
    }
}
