import { SjedniceAppPage } from './app.po';

describe('sjednice-app App', function() {
  let page: SjedniceAppPage;

  beforeEach(() => {
    page = new SjedniceAppPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
