package org.example.data;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.CascadeType;

import java.util.Objects;

@Entity
@Table(name = "ownerships")
@IdClass(Ownership.class)
public final class Ownership {
    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "members_osbb_id")
    private MemberOsbb memberOsbb;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "apartments_id")
    private Apartment apartment;

    public Ownership() {
    }

    public Ownership(final MemberOsbb memberOsbb,
                     final Apartment apartment) {
        this.memberOsbb = memberOsbb;
        this.apartment = apartment;
    }

    public MemberOsbb getMemberOsbb() {
        return memberOsbb;
    }

    public void setMemberOsbb(final MemberOsbb memberOsbb) {
        this.memberOsbb = memberOsbb;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(final Apartment apartment) {
        this.apartment = apartment;
    }

    @Override
    public String toString() {
        return "Ownership{"
                + "memberOsbb="
                + memberOsbb + ", apartment="
                + apartment
                + '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Ownership ownership = (Ownership) o;

        return Objects.equals(memberOsbb, ownership.memberOsbb)
                && Objects.equals(apartment, ownership.apartment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberOsbb, apartment);
    }
}
