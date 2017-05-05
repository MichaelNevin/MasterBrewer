#include <Bridge.h>
#include <HttpClient.h>

int raw= 0;
int Vin= 5;
int counter = 0;
double Vout= 0;
double R1= 1000;
double R2= 0;
double buffer= 0;
double avg = 0.0;
int powner = 1;
int target = 3;
String server = "https://thawing-basin-58241.herokuapp.com/addReading?";
String postData = "";


void setup() {
  
   // Bridge takes about two seconds to start up
  // it can be helpful to use the on-board LED
  // as an indicator for when it has initialized

  pinMode(13, OUTPUT);
  digitalWrite(13, LOW);
  Bridge.begin();
  digitalWrite(13, HIGH);

  Serial.begin(9600);

  while (!Serial); // wait for a serial connection
}

void loop()
{
  HttpClient client;
  delay(2000);
  raw = analogRead(0);
  if(raw) 
  {
    buffer = raw * Vin;
    Vout = (buffer)/1024.0;
    buffer = (Vin/Vout) -1;
    R2 = R1 * buffer;
    counter = counter + 1;
    Serial.print(counter);
    Serial.print("\tVout: ");
    Serial.print(Vout);
    Serial.print("\tResistance: ");
    Serial.println(R2);
    avg = avg + Vout;
    if (counter >= 10)
      {
        avg = avg / 10;
        counter = 0;
        Serial.print("average: ");
        Serial.println(avg);
        postData = "amount=%d&powner=%d&target=%d",avg,powner,target;
        postData = "amount=";
        postData += avg;
        postData += "&powner=";
        postData += powner;
        postData += "&target=";
        postData += target;
        client.post(server, postData);
        Serial.println(postData);

        while (client.available()) {
          char c = client.read();
          Serial.print(c);
        }
        Serial.println();
        Serial.flush();
        avg = 0;
        postData = "";
      }
    delay(1000);
  }
}
