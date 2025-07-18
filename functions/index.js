const functions = require("firebase-functions");
const admin = require("firebase-admin");
admin.initializeApp();

const db = admin.firestore();

exports.registerHospitals = functions.https.onRequest(async (req, res) => {
  if (req.method !== "POST") {
    return res.status(405).send("Method Not Allowed");
  }

  try {
    const hospitals = req.body.hospitals;
    if (!Array.isArray(hospitals)) {
      return res.status(400).json({ error: "hospitals 배열이 필요합니다." });
    }

    const batch = db.batch();
    hospitals.forEach((hospital) => {
      const ref = db.collection("hospitals").doc();
      batch.set(ref, hospital);
    });

    await batch.commit();
    return res.status(200).json({ message: `${hospitals.length}개 병원 등록 완료` });
  } catch (error) {
    console.error("등록 오류:", error);
    return res.status(500).json({ error: "서버 오류" });
  }
});
