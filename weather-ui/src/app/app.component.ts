import { DeleteModalComponent } from './components/delete-modal/delete-modal.component';
import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, startWith, Subject, switchMap, tap } from 'rxjs';
import { WeatherStationService } from './services/weather-station.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent {
  weatherStations: Observable<string[]>;
  weatherForm = this.formBuilder.group({ station: ['', Validators.required] });
  triggerWeatherFetch = new Subject<null>();

  constructor(
    private weatherStationService: WeatherStationService,
    private formBuilder: FormBuilder,
    private modalService: NgbModal
  ) {
    this.weatherStations = this.triggerWeatherFetch.pipe(
      startWith(null),
      switchMap(() => this.weatherStationService.getStations())
    );
  }

  onRefreshStations() {
    this.triggerWeatherFetch.next(null);
  }

  onAddStation() {
    this.weatherStationService
      .addWeatherStation(this.weatherForm.value.station)
      .pipe(tap(() => this.triggerWeatherFetch.next(null)))
      .subscribe();
  }

  onDeleteAllStations() {
    const modalRef = this.modalService.open(DeleteModalComponent);
    modalRef.componentInstance.title = 'Delete Stations';
    modalRef.componentInstance.description =
      'Are you sure you want to delete all Stations?';
    modalRef.result.then((result) => {
      if (result) {
        this.weatherStationService
          .deleteAllWeatherStation()
          .pipe(tap(() => this.triggerWeatherFetch.next(null)))
          .subscribe();
      }
    });
  }

  onDeleteStation(stationId: string) {
    const modalRef = this.modalService.open(DeleteModalComponent);
    modalRef.componentInstance.title = 'Delete Station ' + stationId;
    modalRef.componentInstance.description = `Are you sure you want to delete Station ${stationId}?`;
    modalRef.result.then((result) => {
      if (result) {
        this.weatherStationService
          .deleteWeatherStation(stationId)
          .pipe(tap(() => this.triggerWeatherFetch.next(null)))
          .subscribe();
      }
    });
  }
}
