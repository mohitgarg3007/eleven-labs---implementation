🧪 Step-by-Step: Test in Postman
✅ 1. Launch Postman
Open the Postman app.

✅ 2. Set Request Type & URL
Method: POST

URL: http://localhost:8080/api/speak

✅ 3. Set Headers
Go to the Headers tab and add:


Key	Value
Content-Type	application/json
✅ 4. Set Request Body
Switch to the Body tab:

Choose raw

Select JSON from the dropdown (next to "Text")

Paste this JSON:

json
Copy
Edit
{
  "text": "Hello, this is a test using ElevenLabs!"
}
✅ 5. Send the Request
Hit Send

The response should be a binary audio file (MP3)

✅ 6. Download Audio
Postman will return the audio file as raw binary.

To save the audio:

Click the Save Response → Save to a file

Save it as audio.mp3

Play it locally using any media player (e.g., VLC)

