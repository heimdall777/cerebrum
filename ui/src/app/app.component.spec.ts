import { TestBed, async } from '@angular/core/testing';
import { AppComponent } from './app.component';
import { Http, BaseRequestOptions, HttpModule } from '@angular/http';
import { Injectable } from '@angular/core';
import { MockBackend } from '@angular/http/testing';
import { HelloService } from './service/hello.service';
import { Observable } from "rxjs/Rx";

@Injectable()
class MockHelloService extends HelloService {
  getWelcomeMessage() {
    return Observable.of({'helloMessage': 'Hello World!'});
  }
}

describe('AppComponent', () => {

let service: MockHelloService;
let component: AppComponent;
let http: Http;
let mockBackend: MockBackend;
let baseRequestOptions: BaseRequestOptions;

  beforeEach(async(() => {
    mockBackend = new MockBackend();
    baseRequestOptions = new BaseRequestOptions();
    http = new Http(mockBackend, baseRequestOptions);
    service = new MockHelloService(http);
    component = new AppComponent(service);
    TestBed.configureTestingModule({
      declarations: [
        AppComponent
      ],
      imports: [HttpModule],
      providers: [
        { provide: HelloService, useClass: MockHelloService }
      ]
    }).compileComponents();
  }));

  it('should create the app', async(() => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  }));
  it('should render helloMessage in a h1 tag', async(() => {
    const fixture = TestBed.createComponent(AppComponent);
    fixture.detectChanges();
    const compiled = fixture.debugElement.nativeElement;
    expect(compiled.querySelector('h1').textContent).toContain('Hello World!!');
  }));
});
