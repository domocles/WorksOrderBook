import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { WorksOrderBookSupplierModule } from './supplier/supplier.module';
import { WorksOrderBookAddressModule } from './address/address.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    imports: [
        WorksOrderBookSupplierModule,
        WorksOrderBookAddressModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class WorksOrderBookEntityModule {}
