import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import { appendShape } from '@syncfusion/ej2-maps';

import { AppModule } from './app/app.module';


platformBrowserDynamic().bootstrapModule(AppModule)
  .catch(err => console.error(err));

