import { CloudsDescription, TemperatureUnit } from './weather-enum.model';

export interface WeatherStation {
  temperature: number;
  temperatureUnit: TemperatureUnit;
  clouds: CloudsDescription;
  stationId: string;
}
