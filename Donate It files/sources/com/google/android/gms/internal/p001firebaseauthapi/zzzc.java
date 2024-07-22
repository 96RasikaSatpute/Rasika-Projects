package com.google.android.gms.internal.p001firebaseauthapi;

import java.io.IOException;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzc  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.4 */
final class zzzc implements zzabo {
    private final zzzb zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    private zzzc(zzzb zzzb) {
        zzaag.zzb(zzzb, "input");
        this.zza = zzzb;
        zzzb.zzb = this;
    }

    private final void zzP(int i) throws IOException {
        if ((this.zzb & 7) != i) {
            throw zzaai.zzg();
        }
    }

    private final <T> T zzQ(zzabp<T> zzabp, zzzn zzzn) throws IOException {
        int zzh = ((zzza) this.zza).zzh();
        zzzb zzzb = this.zza;
        if (zzzb.zza < 100) {
            int zzm = zzzb.zzm(zzh);
            T zza2 = zzabp.zza();
            this.zza.zza++;
            zzabp.zzf(zza2, this, zzzn);
            zzabp.zzj(zza2);
            this.zza.zzb(0);
            zzzb zzzb2 = this.zza;
            zzzb2.zza--;
            zzzb2.zzn(zzm);
            return zza2;
        }
        throw new zzaai("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    private final <T> T zzR(zzabp<T> zzabp, zzzn zzzn) throws IOException {
        int i = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        try {
            T zza2 = zzabp.zza();
            zzabp.zzf(zza2, this, zzzn);
            zzabp.zzj(zza2);
            if (this.zzb == this.zzc) {
                return zza2;
            }
            throw zzaai.zzh();
        } finally {
            this.zzc = i;
        }
    }

    private final void zzS(int i) throws IOException {
        if (this.zza.zzp() != i) {
            throw zzaai.zzb();
        }
    }

    private static final void zzT(int i) throws IOException {
        if ((i & 3) != 0) {
            throw zzaai.zzh();
        }
    }

    private static final void zzU(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzaai.zzh();
        }
    }

    public static zzzc zza(zzzb zzzb) {
        zzzc zzzc = zzzb.zzb;
        return zzzc != null ? zzzc : new zzzc(zzzb);
    }

    public final void zzA(List<Long> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzaas) {
            zzaas zzaas = (zzaas) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzaas.zzf(((zzza) this.zza).zzi());
                    if (!this.zza.zzo()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzp = this.zza.zzp() + ((zzza) this.zza).zzh();
                do {
                    zzaas.zzf(((zzza) this.zza).zzi());
                } while (this.zza.zzp() < zzp);
                zzS(zzp);
            } else {
                throw zzaai.zzg();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(((zzza) this.zza).zzi()));
                    if (!this.zza.zzo()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzp2 = this.zza.zzp() + ((zzza) this.zza).zzh();
                do {
                    list.add(Long.valueOf(((zzza) this.zza).zzi()));
                } while (this.zza.zzp() < zzp2);
                zzS(zzp2);
            } else {
                throw zzaai.zzg();
            }
        }
    }

    public final void zzB(List<Integer> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzaab) {
            zzaab zzaab = (zzaab) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzaab.zzf(((zzza) this.zza).zzh());
                    if (!this.zza.zzo()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzp = this.zza.zzp() + ((zzza) this.zza).zzh();
                do {
                    zzaab.zzf(((zzza) this.zza).zzh());
                } while (this.zza.zzp() < zzp);
                zzS(zzp);
            } else {
                throw zzaai.zzg();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(((zzza) this.zza).zzh()));
                    if (!this.zza.zzo()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzp2 = this.zza.zzp() + ((zzza) this.zza).zzh();
                do {
                    list.add(Integer.valueOf(((zzza) this.zza).zzh()));
                } while (this.zza.zzp() < zzp2);
                zzS(zzp2);
            } else {
                throw zzaai.zzg();
            }
        }
    }

    public final void zzC(List<Long> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzaas) {
            zzaas zzaas = (zzaas) list;
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    zzaas.zzf(((zzza) this.zza).zzl());
                    if (!this.zza.zzo()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzh = ((zzza) this.zza).zzh();
                zzU(zzh);
                int zzp = this.zza.zzp() + zzh;
                do {
                    zzaas.zzf(((zzza) this.zza).zzl());
                } while (this.zza.zzp() < zzp);
            } else {
                throw zzaai.zzg();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(((zzza) this.zza).zzl()));
                    if (!this.zza.zzo()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzh2 = ((zzza) this.zza).zzh();
                zzU(zzh2);
                int zzp2 = this.zza.zzp() + zzh2;
                do {
                    list.add(Long.valueOf(((zzza) this.zza).zzl()));
                } while (this.zza.zzp() < zzp2);
            } else {
                throw zzaai.zzg();
            }
        }
    }

    public final void zzD(List<Integer> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzaab) {
            zzaab zzaab = (zzaab) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int zzh = ((zzza) this.zza).zzh();
                zzT(zzh);
                int zzp = this.zza.zzp() + zzh;
                do {
                    zzaab.zzf(((zzza) this.zza).zzk());
                } while (this.zza.zzp() < zzp);
            } else if (i == 5) {
                do {
                    zzaab.zzf(((zzza) this.zza).zzk());
                    if (!this.zza.zzo()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else {
                throw zzaai.zzg();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzh2 = ((zzza) this.zza).zzh();
                zzT(zzh2);
                int zzp2 = this.zza.zzp() + zzh2;
                do {
                    list.add(Integer.valueOf(((zzza) this.zza).zzk()));
                } while (this.zza.zzp() < zzp2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(((zzza) this.zza).zzk()));
                    if (!this.zza.zzo()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else {
                throw zzaai.zzg();
            }
        }
    }

    public final void zzE(List<Boolean> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzyo) {
            zzyo zzyo = (zzyo) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzyo.zzd(this.zza.zzd());
                    if (!this.zza.zzo()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzp = this.zza.zzp() + ((zzza) this.zza).zzh();
                do {
                    zzyo.zzd(this.zza.zzd());
                } while (this.zza.zzp() < zzp);
                zzS(zzp);
            } else {
                throw zzaai.zzg();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Boolean.valueOf(this.zza.zzd()));
                    if (!this.zza.zzo()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzp2 = this.zza.zzp() + ((zzza) this.zza).zzh();
                do {
                    list.add(Boolean.valueOf(this.zza.zzd()));
                } while (this.zza.zzp() < zzp2);
                zzS(zzp2);
            } else {
                throw zzaai.zzg();
            }
        }
    }

    public final <T> void zzG(List<T> list, zzabp<T> zzabp, zzzn zzzn) throws IOException {
        int zza2;
        int i = this.zzb;
        if ((i & 7) == 2) {
            do {
                list.add(zzQ(zzabp, zzzn));
                if (!this.zza.zzo() && this.zzd == 0) {
                    zza2 = this.zza.zza();
                } else {
                    return;
                }
            } while (zza2 == i);
            this.zzd = zza2;
            return;
        }
        throw zzaai.zzg();
    }

    public final <T> void zzH(List<T> list, zzabp<T> zzabp, zzzn zzzn) throws IOException {
        int zza2;
        int i = this.zzb;
        if ((i & 7) == 3) {
            do {
                list.add(zzR(zzabp, zzzn));
                if (!this.zza.zzo() && this.zzd == 0) {
                    zza2 = this.zza.zza();
                } else {
                    return;
                }
            } while (zza2 == i);
            this.zzd = zza2;
            return;
        }
        throw zzaai.zzg();
    }

    public final void zzI(List<zzyy> list) throws IOException {
        int zza2;
        if ((this.zzb & 7) == 2) {
            do {
                list.add(zzq());
                if (!this.zza.zzo()) {
                    zza2 = this.zza.zza();
                } else {
                    return;
                }
            } while (zza2 == this.zzb);
            this.zzd = zza2;
            return;
        }
        throw zzaai.zzg();
    }

    public final void zzJ(List<Integer> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzaab) {
            zzaab zzaab = (zzaab) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzaab.zzf(((zzza) this.zza).zzh());
                    if (!this.zza.zzo()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzp = this.zza.zzp() + ((zzza) this.zza).zzh();
                do {
                    zzaab.zzf(((zzza) this.zza).zzh());
                } while (this.zza.zzp() < zzp);
                zzS(zzp);
            } else {
                throw zzaai.zzg();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(((zzza) this.zza).zzh()));
                    if (!this.zza.zzo()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzp2 = this.zza.zzp() + ((zzza) this.zza).zzh();
                do {
                    list.add(Integer.valueOf(((zzza) this.zza).zzh()));
                } while (this.zza.zzp() < zzp2);
                zzS(zzp2);
            } else {
                throw zzaai.zzg();
            }
        }
    }

    public final void zzK(List<Integer> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzaab) {
            zzaab zzaab = (zzaab) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzaab.zzf(((zzza) this.zza).zzh());
                    if (!this.zza.zzo()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzp = this.zza.zzp() + ((zzza) this.zza).zzh();
                do {
                    zzaab.zzf(((zzza) this.zza).zzh());
                } while (this.zza.zzp() < zzp);
                zzS(zzp);
            } else {
                throw zzaai.zzg();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(((zzza) this.zza).zzh()));
                    if (!this.zza.zzo()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzp2 = this.zza.zzp() + ((zzza) this.zza).zzh();
                do {
                    list.add(Integer.valueOf(((zzza) this.zza).zzh()));
                } while (this.zza.zzp() < zzp2);
                zzS(zzp2);
            } else {
                throw zzaai.zzg();
            }
        }
    }

    public final void zzL(List<Integer> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzaab) {
            zzaab zzaab = (zzaab) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int zzh = ((zzza) this.zza).zzh();
                zzT(zzh);
                int zzp = this.zza.zzp() + zzh;
                do {
                    zzaab.zzf(((zzza) this.zza).zzk());
                } while (this.zza.zzp() < zzp);
            } else if (i == 5) {
                do {
                    zzaab.zzf(((zzza) this.zza).zzk());
                    if (!this.zza.zzo()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else {
                throw zzaai.zzg();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzh2 = ((zzza) this.zza).zzh();
                zzT(zzh2);
                int zzp2 = this.zza.zzp() + zzh2;
                do {
                    list.add(Integer.valueOf(((zzza) this.zza).zzk()));
                } while (this.zza.zzp() < zzp2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(((zzza) this.zza).zzk()));
                    if (!this.zza.zzo()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else {
                throw zzaai.zzg();
            }
        }
    }

    public final void zzM(List<Long> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzaas) {
            zzaas zzaas = (zzaas) list;
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    zzaas.zzf(((zzza) this.zza).zzl());
                    if (!this.zza.zzo()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzh = ((zzza) this.zza).zzh();
                zzU(zzh);
                int zzp = this.zza.zzp() + zzh;
                do {
                    zzaas.zzf(((zzza) this.zza).zzl());
                } while (this.zza.zzp() < zzp);
            } else {
                throw zzaai.zzg();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(((zzza) this.zza).zzl()));
                    if (!this.zza.zzo()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzh2 = ((zzza) this.zza).zzh();
                zzU(zzh2);
                int zzp2 = this.zza.zzp() + zzh2;
                do {
                    list.add(Long.valueOf(((zzza) this.zza).zzl()));
                } while (this.zza.zzp() < zzp2);
            } else {
                throw zzaai.zzg();
            }
        }
    }

    public final void zzN(List<Integer> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzaab) {
            zzaab zzaab = (zzaab) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzaab.zzf(zzza.zzt(((zzza) this.zza).zzh()));
                    if (!this.zza.zzo()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzp = this.zza.zzp() + ((zzza) this.zza).zzh();
                do {
                    zzaab.zzf(zzza.zzt(((zzza) this.zza).zzh()));
                } while (this.zza.zzp() < zzp);
                zzS(zzp);
            } else {
                throw zzaai.zzg();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(zzza.zzt(((zzza) this.zza).zzh())));
                    if (!this.zza.zzo()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzp2 = this.zza.zzp() + ((zzza) this.zza).zzh();
                do {
                    list.add(Integer.valueOf(zzza.zzt(((zzza) this.zza).zzh())));
                } while (this.zza.zzp() < zzp2);
                zzS(zzp2);
            } else {
                throw zzaai.zzg();
            }
        }
    }

    public final void zzO(List<Long> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzaas) {
            zzaas zzaas = (zzaas) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzaas.zzf(zzza.zzu(((zzza) this.zza).zzi()));
                    if (!this.zza.zzo()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzp = this.zza.zzp() + ((zzza) this.zza).zzh();
                do {
                    zzaas.zzf(zzza.zzu(((zzza) this.zza).zzi()));
                } while (this.zza.zzp() < zzp);
                zzS(zzp);
            } else {
                throw zzaai.zzg();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(zzza.zzu(((zzza) this.zza).zzi())));
                    if (!this.zza.zzo()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzp2 = this.zza.zzp() + ((zzza) this.zza).zzh();
                do {
                    list.add(Long.valueOf(zzza.zzu(((zzza) this.zza).zzi())));
                } while (this.zza.zzp() < zzp2);
                zzS(zzp2);
            } else {
                throw zzaai.zzg();
            }
        }
    }

    public final int zzb() throws IOException {
        int i = this.zzd;
        if (i != 0) {
            this.zzb = i;
            this.zzd = 0;
        } else {
            i = this.zza.zza();
            this.zzb = i;
        }
        if (i == 0 || i == this.zzc) {
            return Integer.MAX_VALUE;
        }
        return i >>> 3;
    }

    public final int zzc() {
        return this.zzb;
    }

    public final boolean zzd() throws IOException {
        int i;
        if (this.zza.zzo() || (i = this.zzb) == this.zzc) {
            return false;
        }
        return this.zza.zzc(i);
    }

    public final double zze() throws IOException {
        zzP(1);
        return Double.longBitsToDouble(((zzza) this.zza).zzl());
    }

    public final float zzf() throws IOException {
        zzP(5);
        return Float.intBitsToFloat(((zzza) this.zza).zzk());
    }

    public final long zzg() throws IOException {
        zzP(0);
        return ((zzza) this.zza).zzi();
    }

    public final long zzh() throws IOException {
        zzP(0);
        return ((zzza) this.zza).zzi();
    }

    public final int zzi() throws IOException {
        zzP(0);
        return ((zzza) this.zza).zzh();
    }

    public final long zzj() throws IOException {
        zzP(1);
        return ((zzza) this.zza).zzl();
    }

    public final int zzk() throws IOException {
        zzP(5);
        return ((zzza) this.zza).zzk();
    }

    public final boolean zzl() throws IOException {
        zzP(0);
        return this.zza.zzd();
    }

    public final String zzm() throws IOException {
        zzP(2);
        return this.zza.zze();
    }

    public final String zzn() throws IOException {
        zzP(2);
        return this.zza.zzf();
    }

    public final <T> T zzo(zzabp<T> zzabp, zzzn zzzn) throws IOException {
        zzP(2);
        return zzQ(zzabp, zzzn);
    }

    public final <T> T zzp(zzabp<T> zzabp, zzzn zzzn) throws IOException {
        zzP(3);
        return zzR(zzabp, zzzn);
    }

    public final zzyy zzq() throws IOException {
        zzP(2);
        return this.zza.zzg();
    }

    public final int zzr() throws IOException {
        zzP(0);
        return ((zzza) this.zza).zzh();
    }

    public final int zzs() throws IOException {
        zzP(0);
        return ((zzza) this.zza).zzh();
    }

    public final int zzt() throws IOException {
        zzP(5);
        return ((zzza) this.zza).zzk();
    }

    public final long zzu() throws IOException {
        zzP(1);
        return ((zzza) this.zza).zzl();
    }

    public final int zzv() throws IOException {
        zzP(0);
        return zzza.zzt(((zzza) this.zza).zzh());
    }

    public final long zzw() throws IOException {
        zzP(0);
        return zzza.zzu(((zzza) this.zza).zzi());
    }

    public final void zzx(List<Double> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzzk) {
            zzzk zzzk = (zzzk) list;
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    zzzk.zzd(Double.longBitsToDouble(((zzza) this.zza).zzl()));
                    if (!this.zza.zzo()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzh = ((zzza) this.zza).zzh();
                zzU(zzh);
                int zzp = this.zza.zzp() + zzh;
                do {
                    zzzk.zzd(Double.longBitsToDouble(((zzza) this.zza).zzl()));
                } while (this.zza.zzp() < zzp);
            } else {
                throw zzaai.zzg();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 1) {
                do {
                    list.add(Double.valueOf(Double.longBitsToDouble(((zzza) this.zza).zzl())));
                    if (!this.zza.zzo()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzh2 = ((zzza) this.zza).zzh();
                zzU(zzh2);
                int zzp2 = this.zza.zzp() + zzh2;
                do {
                    list.add(Double.valueOf(Double.longBitsToDouble(((zzza) this.zza).zzl())));
                } while (this.zza.zzp() < zzp2);
            } else {
                throw zzaai.zzg();
            }
        }
    }

    public final void zzy(List<Float> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzzu) {
            zzzu zzzu = (zzzu) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int zzh = ((zzza) this.zza).zzh();
                zzT(zzh);
                int zzp = this.zza.zzp() + zzh;
                do {
                    zzzu.zzd(Float.intBitsToFloat(((zzza) this.zza).zzk()));
                } while (this.zza.zzp() < zzp);
            } else if (i == 5) {
                do {
                    zzzu.zzd(Float.intBitsToFloat(((zzza) this.zza).zzk()));
                    if (!this.zza.zzo()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else {
                throw zzaai.zzg();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzh2 = ((zzza) this.zza).zzh();
                zzT(zzh2);
                int zzp2 = this.zza.zzp() + zzh2;
                do {
                    list.add(Float.valueOf(Float.intBitsToFloat(((zzza) this.zza).zzk())));
                } while (this.zza.zzp() < zzp2);
            } else if (i2 == 5) {
                do {
                    list.add(Float.valueOf(Float.intBitsToFloat(((zzza) this.zza).zzk())));
                    if (!this.zza.zzo()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else {
                throw zzaai.zzg();
            }
        }
    }

    public final void zzz(List<Long> list) throws IOException {
        int zza2;
        int zza3;
        if (list instanceof zzaas) {
            zzaas zzaas = (zzaas) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzaas.zzf(((zzza) this.zza).zzi());
                    if (!this.zza.zzo()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzp = this.zza.zzp() + ((zzza) this.zza).zzh();
                do {
                    zzaas.zzf(((zzza) this.zza).zzi());
                } while (this.zza.zzp() < zzp);
                zzS(zzp);
            } else {
                throw zzaai.zzg();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(((zzza) this.zza).zzi()));
                    if (!this.zza.zzo()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzp2 = this.zza.zzp() + ((zzza) this.zza).zzh();
                do {
                    list.add(Long.valueOf(((zzza) this.zza).zzi()));
                } while (this.zza.zzp() < zzp2);
                zzS(zzp2);
            } else {
                throw zzaai.zzg();
            }
        }
    }

    public final void zzF(List<String> list, boolean z) throws IOException {
        int zza2;
        int zza3;
        if ((this.zzb & 7) != 2) {
            throw zzaai.zzg();
        } else if ((list instanceof zzaan) && !z) {
            zzaan zzaan = (zzaan) list;
            do {
                zzaan.zzf(zzq());
                if (!this.zza.zzo()) {
                    zza3 = this.zza.zza();
                } else {
                    return;
                }
            } while (zza3 == this.zzb);
            this.zzd = zza3;
        } else {
            do {
                list.add(z ? zzn() : zzm());
                if (!this.zza.zzo()) {
                    zza2 = this.zza.zza();
                } else {
                    return;
                }
            } while (zza2 == this.zzb);
            this.zzd = zza2;
        }
    }
}
