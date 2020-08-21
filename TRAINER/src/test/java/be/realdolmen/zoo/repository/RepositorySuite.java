package be.realdolmen.zoo.repository;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Suite.SuiteClasses({AnimalRepositoryTest.class})
@Categories.ExcludeCategory(Slow.class)
public class RepositorySuite {
}
