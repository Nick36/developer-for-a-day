import { WeatherMap } from './../models/weather-map.model';
import { WeatherStation } from './../models/weather-station.model';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class WeatherStationService {
  constructor(private http: HttpClient) {}

  getStationsMap() {
    return this.http.get<WeatherMap>('/api/map');
  }

  getStations() {
    return this.http.get<string[]>('/api/station');
  }

  getWeatherStation(stationId: string) {
    return this.http.get<WeatherStation>(`/api/weather/${stationId}`);
  }

  addWeatherStation(stationId: string) {
    return this.http.post(`/api/station/${stationId}`, null);
  }

  deleteWeatherStation(stationId: string) {
    return this.http.delete(`/api/station/${stationId}`);
  }

  deleteAllWeatherStation() {
    return this.http.delete(`/api/station`);
  }
}
