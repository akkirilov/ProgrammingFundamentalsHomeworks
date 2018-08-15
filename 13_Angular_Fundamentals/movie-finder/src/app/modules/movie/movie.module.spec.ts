import { MovieModule } from './movie.module';

describe('MovieModuleModule', () => {
  let movieModuleModule: MovieModule;

  beforeEach(() => {
    movieModuleModule = new MovieModule();
  });

  it('should create an instance', () => {
    expect(movieModuleModule).toBeTruthy();
  });
});
